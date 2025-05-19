package com.logics;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class JavaEnumExample {
    enum Type implements Map.Entry<Type, String> {
        TYPE{
            @Override
            public Type getKey() {
                return TYPE;
            }

            @Override
            public String getValue() {
                return "";
            }

            @Override
            public String setValue(String value) {
                return "";
            }
        }
        ,
        TYPE2 {
            @Override
            public Type getKey() {
                return TYPE2;
            }

            @Override
            public String getValue() {
                return "my type 2 value";
            }

            @Override
            public String setValue(String value) {
                return "my test2 value";
            }
        }

    }


    public static void main(String[] args) {
        System.out.println(Type.TYPE.getValue());
    }


}
