package com.java.mae.jsloader;

/**
 * @Author: Mae
 * @Date: 2020/8/9 4:48 下午
 */
public enum RetValueTypeEnum {

    RET_BYTE_TYPE("BYTE", Byte.TYPE),
    RET_CHAR_TYPE("CHAR", Character.TYPE),
    RET_INT_TYPE("INT", Integer.TYPE),
    RET_LONG_TYPE("LONG", Long.TYPE),
    RET_SHORT_TYPE("SHORT", Short.TYPE),
    RET_FLOAT_TYPE("FLOAT", Float.TYPE),
    RET_DOUBLE_TYPE("DOUBLE", Double.TYPE),
    RET_BOOLEAN_TYPE("BOOLEAN", Boolean.TYPE),
    RET_STRING_TYPE("STRING", String.class);

    private String type;
    private Class<?> clsName;

    RetValueTypeEnum(String type, Class<?> clsName) {
        this.type = type;
        this.clsName = clsName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Class<?> getClsName() {
        return clsName;
    }

    public void setClsName(Class<?> clsName) {
        this.clsName = clsName;
    }

    public static RetValueTypeEnum getByCode(String type) {
        for (RetValueTypeEnum retValueTypeEnum : RetValueTypeEnum.values()) {
            if (retValueTypeEnum.getType().equals(type)) {
                return retValueTypeEnum;
            }
        }
        throw new RuntimeException("No RetValueTypeEnum match for type " + type);
    }
}
