package com.java.mae.jsloader;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Mae
 * @Date: 2020/8/9 7:05 下午
 */
public class RetTypeTest {
    @Test
    public void testgetByType() {
        // byte
        Assert.assertEquals(RetTypeEnum.RET_BYTE_TYPE, RetTypeEnum.getByType("Byte"));

        // boolean
        Assert.assertEquals(RetTypeEnum.RET_BOOLEAN_TYPE, RetTypeEnum.getByType("Boolean"));

        // char
        Assert.assertEquals(RetTypeEnum.RET_CHAR_TYPE, RetTypeEnum.getByType("Char"));

        // integer
        Assert.assertEquals(RetTypeEnum.RET_INT_TYPE, RetTypeEnum.getByType("Integer"));

        // short
        Assert.assertEquals(RetTypeEnum.RET_SHORT_TYPE, RetTypeEnum.getByType("Short"));

        // long
        Assert.assertEquals(RetTypeEnum.RET_LONG_TYPE, RetTypeEnum.getByType("Long"));

        // double
        Assert.assertEquals(RetTypeEnum.RET_DOUBLE_TYPE, RetTypeEnum.getByType("Double"));

        // float
        Assert.assertEquals(RetTypeEnum.RET_FLOAT_TYPE, RetTypeEnum.getByType("Float"));

        // string
        Assert.assertEquals(RetTypeEnum.RET_STRING_TYPE, RetTypeEnum.getByType("String"));
    }
}
