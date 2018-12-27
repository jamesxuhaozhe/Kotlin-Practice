package jav;

import strings.StringFunctions;

import java.util.Arrays;

public class JavaClass {

    public static void main(String[] args) {

        final String s = StringFunctions.joinToString(Arrays.asList(1, 2, 3, 4, 5), "-", "(", ")");
        System.out.println(s);

        char c = StringFunctions.lastChar("Java");

        char c1 = StringFunctions.getLastChar("stuff");
        StringFunctions.setLastChar(new StringBuilder("sb"), '!');


    }
}
