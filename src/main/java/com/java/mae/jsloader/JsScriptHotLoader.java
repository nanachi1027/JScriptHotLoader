package com.java.mae.jsloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: Mae
 * @Date: 2020/8/9 4:47 下午
 * <p>
 * Note: NASHORN gonna deprecate since JDK 11 (ToT)/~
 */
public class JsScriptHotLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsScriptHotLoader.class);
    private static final ScriptEngineManager seManger = new ScriptEngineManager();
    private static final String JS_SCRIPT_NAME = "nashorn";
    private static volatile JsScriptHotLoader instance = null;

    public JsScriptHotLoader() {
    }

    /**
     * Method to execute java script by given js file dir, context value, function name and return value type.
     *
     * @param jscriptDir    java script file directory;
     * @param engineContext context/global variables provided for function calling;
     * @param execFuncName  name of the function gonna be called inside the java script file;
     * @param retType       return value's type of be executed function;
     * @return return value of the function execution result.
     */
    public RetValue execJScriptFunction(String jscriptDir, Map<String, Object> engineContext,
                                        String execFuncName, RetTypeEnum retType) {
        ScriptEngine jsEngineHandler = getJScriptEngine(jscriptDir, engineContext);
        RetValue retValue = execFunc(jscriptDir, jsEngineHandler, execFuncName, retType);
        return retValue;
    }

    /**
     * Method to create and initialize JS ScriptEngine instance by given
     * java script file and context variable key & value pair.
     *
     * @param jscriptDir    java script file's absolute path name;
     * @param engineContext variables in key & value pair wanna passing into engine context;
     * @return java script engine instance.
     */
    private ScriptEngine getJScriptEngine(String jscriptDir, Map<String, Object> engineContext) {
        File jsFilePath = new File(jscriptDir);
        if (jscriptDir == null || !jsFilePath.exists() || !jsFilePath.isFile()) {
            throw new RuntimeException(String.format("Java Script File: %s not illegal!", jscriptDir));
        }
        ScriptEngine scriptEngine = seManger.getEngineByName(JS_SCRIPT_NAME);
        scriptEngine.put("LOG", LOGGER);
        try (FileReader fd = new FileReader(jsFilePath)) {
            LOGGER.info("Exec Java Script File: " + jscriptDir);
            // pass all context items to script context
            Iterator<Map.Entry<String, Object>> iter = engineContext.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Object> it = iter.next();
                scriptEngine.put(it.getKey(), it.getValue());
            }
            // reader's file content and context (k,v) all passing into script engine now
            scriptEngine.eval(fd);
        } catch (FileNotFoundException e) {
            LOGGER.warn(String.format("failed to exec java script file %s, by %s",
                    jscriptDir, e.getMessage()));
            throw new RuntimeException(String.format("failed to exec java script file %s by %s",
                    jscriptDir, e.getMessage()));
        } catch (ScriptException e) {
            LOGGER.warn(String.format("failed to exec java script file %s by %s",
                    jscriptDir, e.getMessage()));
            throw new RuntimeException(String.format("failed to exec java script file %s by %s",
                    jscriptDir, e.getMessage()));

        } catch (Throwable ex) {
            LOGGER.warn(String.format("failed to exec java script file %s by %s",
                    jscriptDir, ex.getMessage()));
            throw new RuntimeException(String.format("failed to exec java script file %s by %s",
                    jscriptDir, ex.getMessage()));
        }
        // if we get here it means java script is created & init
        return scriptEngine;
    }

    /**
     * Method responsible for execute given java script func and return func's value by given java script file
     * , js engine, function name and function's return type.
     * @param jscriptDir java script file path;
     * @param jsEngine java script engine instance;
     * @param execFuncName java script function name which gonna be called by script engine;
     * @param retType js func's return value type;
     * @return exec func's return value.
     */
    private RetValue execFunc(String jscriptDir, ScriptEngine jsEngine, String execFuncName,
                              RetTypeEnum retType) {
        RetValue retValue = new RetValue();
        if (jsEngine == null) return retValue;
        try {
            LOGGER.info(String.format("Exec function: %s, retType: %s", execFuncName, retType.getType()));
            jsEngine.put("functionName", execFuncName);
            Invocable invokeFunc = (Invocable) jsEngine;
            Object retObj = invokeFunc.invokeFunction(execFuncName);
            retValue.transferRetValue(retObj, retType);
        } catch (ScriptException e) {
            LOGGER.warn(String.format("failed to execute script %s caused by %s", jscriptDir, e.getMessage()));
            throw new RuntimeException(String.format("failed to execute script %s caused by %s", jscriptDir, e.getMessage()));
        } catch (Throwable e) {
            LOGGER.warn(String.format("failed to execute script %s caused by %s", jscriptDir, e.getMessage()));
            throw new RuntimeException(String.format("failed to execute script %s caused by %s", jscriptDir, e.getMessage()));
        }
        return retValue;
    }

    // --- static methods ---
    public static JsScriptHotLoader getInstance() {
        if (instance == null) {
            instance = new JsScriptHotLoader();
        }
        return instance;
    }

}
