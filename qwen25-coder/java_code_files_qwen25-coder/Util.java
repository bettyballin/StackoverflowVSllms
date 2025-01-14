package com.example.util;

public class Util {
    public static boolean equals(Object obj1, Object obj2) {
        if (obj1 == null) {
            return obj2 == null;
        }
        return obj1.equals(obj2);
    }

    public static void main(String[] args) {
    }
}