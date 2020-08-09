package com.java.mae.jsloader;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Mae
 * @Date: 2020/8/9 7:05 下午
 */
public class RetValueTest {
    @Test
    public void testBoolean () {
        RetValue retValue = new RetValue();
        RetTypeEnum retTypeEnum = RetTypeEnum.RET_BOOLEAN_TYPE;
        String trueStr = "true";
        String falseStr = "false";

        Object obj = (Object) (new Boolean(true));
        try {
            retValue.transferRetValue(obj, retTypeEnum);
            Assert.assertTrue(retValue.isValueInit());
            Assert.assertEquals(retValue.getRetBoolean(), true);
            Assert.assertEquals(retValue.getRetByte(), (byte)0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testString() {
        RetValue retValue = new RetValue();
        RetTypeEnum retType = RetTypeEnum.RET_STRING_TYPE;
        String strString = "HelloWorld";

        Object obj = (Object) (strString);

        try {
            retValue.transferRetValue(obj, retType);
            Assert.assertTrue(retValue.isValueInit());
            Assert.assertEquals(retValue.getRetString(), strString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInteger() {
        RetValue retValue = new RetValue();
        RetTypeEnum retType = RetTypeEnum.RET_INT_TYPE;
        Integer intValue = 2948;
        Object obj = (Object) (new Integer(intValue));

        try {
            retValue.transferRetValue(obj, retType);
            Assert.assertTrue(retValue.isValueInit());
            Assert.assertTrue(retValue.getRetInt() == intValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
