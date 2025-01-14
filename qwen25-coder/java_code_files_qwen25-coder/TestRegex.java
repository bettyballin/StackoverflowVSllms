package com.s2i.egc.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void main(String[] args) {

        String bodyText = "text text text [[st: aaa bbb ccc ddd eee fff]] text text\n" +
                          "text text [[st: ggg hhh iii jjj kkk\nlll mmm nnn]] text text text";

        // Use .*? to make the regex non-greedy
        String currentPattern = "\\[\\[st:(.*?)\\]\\]";

        Pattern myPattern = Pattern.compile(currentPattern, Pattern.DOTALL);

        Matcher myMatcher = myPattern.matcher(bodyText);

        int i = 1;

        while (myMatcher.find()) {
            // Use the captured group to get the text between separators
            String match = myMatcher.group(1).trim();
            System.out.println(match + " (match #" + i + ")");
            i++;
        }                           
    }
}