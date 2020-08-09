package com.mae.scriptengine;

import org.junit.Test;

import javax.script.ScriptEngineManager;

/**
 * @Author: Mae
 * @Date: 2020/8/9 4:14 下午
 */
public class ScriptManagerTest {

    @Test
    public void initScriptEngine() {
        ScriptEngineManager seManger = new ScriptEngineManager();
        String defaultScriptName = "JavaScript";
        String nashornName = "nashorn";

        String defaultClsScriptEngineName = seManger.getEngineByName(defaultScriptName).getClass().getName();
        String nashornClsScriptEngineName = seManger.getEngineByName(nashornName).getClass().getName();

        System.out.println(defaultClsScriptEngineName);
        System.out.println(nashornClsScriptEngineName);
    }
}
