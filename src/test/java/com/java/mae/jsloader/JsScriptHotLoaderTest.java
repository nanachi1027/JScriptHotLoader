package com.java.mae.jsloader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Mae
 * @Date: 2020/8/9 7:31 下午
 */
public class JsScriptHotLoaderTest {
    private static final String jsFileName = "simple_config.js";
    private String jsFilePath = null;

    @Before
    public void init() {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(jsFileName).getFile());
        jsFilePath = Thread.currentThread().getContextClassLoader().getResource(jsFileName).getFile();
        Assert.assertNotNull(jsFilePath);
        JsScriptHotLoader jsScriptHotLoader = JsScriptHotLoader.getInstance();
        Assert.assertNotNull(jsScriptHotLoader);
    }

    /**
     * Trying to invoke 'sparkCoresMaxEnabled' function in java script: simple_config.js
     * In simple_config.js:
     * <p>
     * `function sparkCoresMax() {
     * if (sparkCoresMaxEnabled) {
     * return 20;
     * } else {
     * return 0;
     * }
     * }`
     */
    @Test
    public void testSparkCoresMaxEnabled() {
        JsScriptHotLoader jsScriptHotLoader = JsScriptHotLoader.getInstance();
        Assert.assertNotNull(jsScriptHotLoader);
        String functionName = "sparkCoresMax";
        Map<String, Object> engineContext = new HashMap<>();
        engineContext.put("sparkCoresMaxEnabled", true);

        RetValue retValue = jsScriptHotLoader.execJScriptFunction(jsFilePath, engineContext,
                functionName, RetTypeEnum.RET_INT_TYPE);
        Assert.assertNotNull(retValue);
        Assert.assertTrue(retValue.isValueInit());
        Assert.assertEquals(20, retValue.getRetInt());
    }
}
