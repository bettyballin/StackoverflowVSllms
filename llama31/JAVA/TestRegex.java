package com.s2i.egc.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void main(String[] args) {

        String bodyText = "text text text [[st: aaa bbb ccc ddd eee fff]] text text text text [[st: ggg hhh iii jjj kkk lll mmm nnn]] text text text";

        String currentPattern = "\\[\\[st:.*?\\]\\]"; // Note the ? after *

        Pattern myPattern = Pattern.compile(currentPattern, Pattern.DOTALL);

        Matcher myMatcher = myPattern.matcher(bodyText);

        int i = 1;

        while (myMatcher.find()) {
          String match = bodyText.substring(myMatcher.start() + 5, myMatcher.end() - 2); // adjusted end index
          System.out.println(match + " (match #" + i + ")");
          i++;
        }                           

    }

}