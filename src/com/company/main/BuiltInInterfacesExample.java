package com.company.main;

import java.util.Objects;
import java.util.function.Predicate;

public class BuiltInInterfacesExample {

    public static void main(String[] args) {

        predicate();
    }

    private static void predicate() {
        /*
         * Predicates are boolean-valued functions of one argument.
         * The interface contains various default methods for composing predicates to complex logical terms (and, or, negate)
         * */
       String value = "Hello";
       Predicate<String> predicateString = (s -> s.length() > 0);

       printResult("test",predicateString.test(value));
       printResult("negate", predicateString.negate().test(value));


        //EX1
        Predicate<Boolean> nonNull = (Objects::nonNull); // (b -> Objects.nonNull(b));

        //EX2
        Predicate<Boolean> isNull = Objects::isNull;     // (b -> Objects.isNull(b));

        //EX3
        Predicate<String> isEmpty = String::isEmpty;       // (b -> String.isEmpty(b));

        //EX4
        Predicate<String> isNotEmpty = isEmpty.negate(); //  (b -> isEmpty.negate().test(b));

        //EX4 can be written as
        isNotEmpty = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return isEmpty.negate().test(s);
            }
        };
    }

    private static void printResult(String type, boolean test) {
        System.out.println();
        System.out.printf("predicate, %s %s",type, test);
    }
}
