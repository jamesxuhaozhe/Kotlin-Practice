package jav;

import chapter5.Milk;
import strings.StringFunctions;

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


        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 54, 8, 10, 34, 5, 6, 44);

        lists.stream().map(JavaClass::mapFunc).filter(JavaClass::predicateLogic).toArray();
    }

    private static Integer mapFunc(Integer integer) {
        System.out.println("Map " + integer);
        return integer * integer;
    }

    private static boolean predicateLogic(Integer integer) {
        System.out.println("filter " + integer);
        return integer > 20;
    }
}
