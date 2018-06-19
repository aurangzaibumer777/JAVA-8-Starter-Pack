package com.company.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class LambdaExamples {

    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Shifoo", "Oogway", "Tigress", "Mantis");

        sortAscending(nameList, 0);
        System.out.println(nameList);


        //using lambda and functional interface together to make something like this
        NumericTest isGreater = n -> n > 0;
        NumericTest isNegative = n -> n < 0;

        // Output: false
        System.out.println(isGreater.computeTest(-3));

        // Output: false
        System.out.println(isNegative.computeTest(5));

        // Output: True
        System.out.println(isGreater.computeTest(3));

        //Example 2 in a Traditional Way
        MyGreeting morningGreetingOld = new MyGreeting() {
            @Override
            public String greetTo(String str) {
                return "Good Morning " + str + "!";
            }
        };
        System.out.println(morningGreetingOld.greetTo("John OLD"));


        //Example 2 using Lambda
        MyGreeting morningGreetingNew = (str) -> "Good Morning " + str + "!";
        System.out.println(morningGreetingNew.greetTo("John NEW"));

    }

    private static void sortAscending(List<String> names, int ways) {
        //Use of Traditional way VS use of lambda in different ways
        switch (ways) {
            case 0:
                //Traditional way
                Collections.sort(names, new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        return a.compareTo(b);
                    }
                });
            case 1:
                //Use of lambda
                Collections.sort(names, (String a, String b) -> {
                    return a.compareTo(b);
                });
            case 2:
                //Can be shorter to
                Collections.sort(names, (String a, String b) -> a.compareTo(b));
            case 3:
                //Can be more shorter to one line (removing explicitly defined dataType)
                Collections.sort(names, (a, b) -> a.compareTo(b));
            case 4:
                //replace Collection sort to List.sort and use of Comparator's natural order method if using ascending order
                names.sort(Comparator.naturalOrder());
            default:
                break;
        }

    }

    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Function<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Function<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }

    interface NumericTest {
        boolean computeTest(int n);
    }

    interface MyGreeting {
        String greetTo(String str);
    }


}
