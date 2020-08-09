package com.java.mae.jsloader;

/**
 * @Author: Mae
 * @Date: 2020/8/9 4:48 下午
 */
public enum RetTypeEnum {

    RET_BYTE_TYPE("Byte", Byte.TYPE),
    RET_CHAR_TYPE("Character", Character.TYPE),
    RET_INT_TYPE("Integer", Integer.TYPE),
    RET_LONG_TYPE("Long", Long.TYPE),
    RET_SHORT_TYPE("Short", Short.TYPE),
    RET_FLOAT_TYPE("Float", Float.TYPE),
    RET_DOUBLE_TYPE("Double", Double.TYPE),
    RET_BOOLEAN_TYPE("Boolean", Boolean.TYPE),
    RET_STRING_TYPE("String", String.class);

    private String type;
    private Class<?> clsName;

    RetTypeEnum(String type, Class<?> clsName) {
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

    public static RetTypeEnum getByType(String type) {
        for (RetTypeEnum retTypeEnum : RetTypeEnum.values()) {
            if (retTypeEnum.getType().equals(type)) {
                return retTypeEnum;
            }
        }
        throw new RuntimeException("No RetValueTypeEnum match for type " + type);
    }
}
