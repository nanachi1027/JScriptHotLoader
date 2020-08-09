package com.java.mae.jsloader;

/**
 * @Author: Mae
 * @Date: 2020/8/9 4:48 下午
 * <p>
 * Class wraps java basic value
 */
public class RetValue {
    private boolean isValueInit = false;

    private boolean retBoolean = false;
    private byte retByte = (byte) 0;
    private char retChar = '\0';
    private short retShort = (short) 0;
    private int retInt = 0;
    private long retLong = 0L;
    private float retFloat = (float) 0.0;
    private double retDouble = 0.0;
    private String retString = "";

    // get & set
    public boolean getRetBoolean() {
        return retBoolean;
    }

    public void setRetBoolean(boolean retBoolean) {
        this.isValueInit = true;
        this.retBoolean = retBoolean;
    }

    public byte getRetByte() {
        return retByte;
    }

    public void setRetByte(byte retByte) {
        this.isValueInit = true;
        this.retByte = retByte;
    }

    public char getRetChar() {
        return retChar;
    }

    public void setRetChar(char retChar) {
        this.isValueInit = true;
        this.retChar = retChar;
    }

    public short getRetShort() {
        return retShort;
    }

    public void setRetShort(short retShort) {
        this.isValueInit = true;
        this.retShort = retShort;
    }

    public int getRetInt() {
        return retInt;
    }

    public void setRetInt(int retInt) {
        this.isValueInit = true;
        this.retInt = retInt;
    }

    public long getRetLong() {
        return retLong;
    }

    public void setRetLong(long retLong) {
        this.isValueInit = true;
        this.retLong = retLong;
    }

    public float getRetFloat() {
        return retFloat;
    }

    public void setRetFloat(float retFloat) {
        this.isValueInit = true;
        this.retFloat = retFloat;
    }

    public double getRetDouble() {
        return retDouble;
    }

    public void setRetDouble(double retDouble) {
        this.isValueInit = true;
        this.retDouble = retDouble;
    }

    public String getRetString() {
        return retString;
    }

    public void setRetString(String retString) {
        this.isValueInit = true;
        this.retString = retString;
    }

    public boolean isValueInit() {
        return isValueInit;
    }

    public void setValueInit(boolean valueInit) {
        this.isValueInit = true;
        isValueInit = valueInit;
    }

    /**
     * Method responsible for transfer obj to corresponding type's instance.
     *
     * @param obj     obj instance
     * @param retType return value type
     * @return ret value which wraps corresponding type obj
     */
    public void transferRetValue(Object obj, RetTypeEnum retType) throws Exception {
        String retString = String.valueOf(obj);

        switch (retType) {
            case RET_BOOLEAN_TYPE:
                setRetBoolean(Boolean.valueOf(retString));
                break;
            case RET_BYTE_TYPE:
                setRetByte(Byte.valueOf(retString));
                break;
            case RET_CHAR_TYPE:
                setRetChar(Character.valueOf(retString.charAt(0)));
                break;
            case RET_SHORT_TYPE:
                setRetShort(Short.valueOf(retString));
                break;
            case RET_INT_TYPE:
                setRetInt(Integer.valueOf(retString));
                break;
            case RET_LONG_TYPE:
                setRetLong(Long.valueOf(retString));
                break;
            case RET_FLOAT_TYPE:
                setRetFloat(Float.valueOf(retString));
                break;
            case RET_DOUBLE_TYPE:
                setRetDouble(Double.valueOf(retString));
                break;
            case RET_STRING_TYPE:
                setRetString(retString);
                break;
            default:
                throw new RuntimeException("Failed to transer ret value by given retType: " + retType);
        }
    }
}
