/*
 * Decompiled with CFR 0.152.
 */
package com.s2i.egc.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] stringArray) {
        String string = "text text text [[st: aaa bbb ccc ddd eee fff]] text text text text [[st: ggg hhh iii jjj kkk lll mmm nnn]] text text text";
        String string2 = "\\[\\[st:.*?\\]\\]";
        Pattern pattern = Pattern.compile(string2, 32);
        Matcher matcher = pattern.matcher(string);
        int n = 1;
        while (matcher.find()) {
            String string3 = string.substring(matcher.start() + 5, matcher.end() - 2);
            System.out.println(string3 + " (match #" + n + ")");
            ++n;
        }
    }
}
