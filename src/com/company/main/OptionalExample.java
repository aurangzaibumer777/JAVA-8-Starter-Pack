package com.company.main;

import java.util.Optional;

/*
Optional is a simple container for a value which may be null or non-null.
Think of a method which may return a non-null result but sometimes return nothing.
Instead of returning null you return an Optional in Java 8.
* */

public class OptionalExample {


    public static void main(String[] args) {
        basicExample();

        advanceExampleMapAndFlatMap();

        advanceExampleForFilter();

        advanceExampleifPresentAndisPresent();

        advanceExampleOrElse();
    }

    private static void advanceExampleOrElse() {
        System.out.println();
        System.out.println("OPTIONAL OR-ELSE EXAMPLE");
        String answer = null;
        Optional<String> stringOptional = Optional.ofNullable(answer);
        System.out.printf("get Optional value if not empty ? %s \n", stringOptional.orElse("Answer has an empty container"));
    }

    private static void advanceExampleifPresentAndisPresent() {
        System.out.println("IS PRESENT / IF PRESENT");
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        if (gender.isPresent()) {
            System.out.println("Value available.");
        } else {
            System.out.println("Value not available.");
        }

        //condition succeed, output print
        gender.ifPresent(g -> System.out.printf("In gender Option, value available i.e. %s", g));

        //condition failed, no output print
        emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));
    }

    private static void advanceExampleForFilter() {
        System.out.println("FILTER");
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        //Filter on Optional
        System.out.println(gender.filter(g -> g.equals("male"))); //Optional.empty
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional[MALE]
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional.empty
    }

    private static void advanceExampleMapAndFlatMap() {
        System.out.println("MAP/FLAT MAP");
        Optional<String> s = Optional.of("input");
        Optional<String> rate = null;
        //Use map if the function returns the object you need
        System.out.println(s.map(OptionalExample::getOutput));
        //Use flatMap if the function returns an Optional.
        System.out.println(s.flatMap(OptionalExample::getOutputOpt));

    }

    private static void basicExample() {
        String specialCar = null;
        Optional<String> optional = Optional.of("ford");

        //this method returns if optional container is null or not
        System.out.printf("is Optional container is empty ? %s \n", isOptionalContainerEmpty(optional));

        //this method returns value if exist else show exception
        System.out.printf("get Optional value if not empty ? %s \n", optional.get());


        //this method returns the value if present else the argument value would be returned
        System.out.printf("get Optional value if not empty ? %s \n", optional.orElse("vehicle"));

        //Use of lambda in Example 1
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

        //Use of non-lambda in Example 1
        if (optional.isPresent()){
            System.out.println(optional.get().charAt(0));
        }

        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        // gonna throw java.lang.NullPointerException
        try {
            System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    //Using Optional
    private static boolean isOptionalContainerEmpty(Optional<String> optional) {
        return optional.isPresent();
    }

    //Traditional way
    private static boolean isOptionalContainerEmpty(String value){
        return value != null;
    }

    //Methods used for Optional.map / Optional.flatmap
    private static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }

    private static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }
}
