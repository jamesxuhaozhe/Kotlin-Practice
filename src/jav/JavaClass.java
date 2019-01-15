package jav;

import chapter5.Milk;
import strings.StringFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaClass {

    public static void main(String[] args) {

        final String s = StringFunctions.joinToString(Arrays.asList(1, 2, 3, 4, 5), "-", "(", ")");
        System.out.println(s);

        char c = StringFunctions.lastChar("Java");

        char c1 = StringFunctions.getLastChar("stuff");
        StringFunctions.setLastChar(new StringBuilder("sb"), '!');

        List<Milk> milks = Arrays.asList(new Milk("james", 1), new Milk("hsfsdf", 3), new Milk("you", 6));



    }
}
