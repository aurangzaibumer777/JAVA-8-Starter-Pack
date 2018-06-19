package com.company.main;

import java.util.*;
/*
* A java.util.Stream represents a sequence of elements on which one or more operations can be performed.
* Stream operations are either intermediate or terminal. While terminal operations return a result of a certain type,
* intermediate operations return the stream itself so you can chain multiple method calls in a row.
* Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported).
* Stream operations can either be executed sequentially or parallely.
* */
public class StreamExample {

    public static void main(String[] args) {

        List<String> datasource = loadDatasource();

        basicExamples(datasource);

        streamMap(datasource);

        streamMatch(datasource);

        streamCount(datasource);

        streamReduce(datasource);


    }

    private static void streamMap(List<String> datasource) {

        //stream mapping - edit elements of datasource to upperCase using Map
        printResult("STREAM MAP");
        datasource.stream().map(s -> s.toUpperCase()).forEach(s -> printResult(s));
        //or can be written like this
        //****datasource.stream().map(String::toUpperCase).forEach(System.out::println);***


        //stream mapping - edit elements of datasource to upperCase using Map & Sort
        printResult("STREAM MAP WITH SORT");
        datasource.stream().map(s -> s.toUpperCase()).sorted(Comparator.naturalOrder()).forEach(s -> printResult(s));


        //stream mapping - edit elements of datasource to lowercase using Map & filter them before sort
        printResult("STREAM MAP WITH SORT AND FILTER");
        datasource.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("A")).sorted(Comparator.naturalOrder()).forEach(s -> printResult(s));
        //Expected Result = AAA1, AAA2

        //but if we do like this
        printResult("STREAM WITH SORT AND FILTER WITHOUT USING MAP");
        datasource.stream().filter(s -> s.toUpperCase().startsWith("A")).sorted(Comparator.naturalOrder()).forEach(s -> printResult(s));
        //Expected Result would be aaa1, aaa2

    }

    /**
     *  What is Reduce?

     Many times, we need to perform operations where a stream reduces to single resultant value,
     for example, maximum, minimum, sum, product, etc. Reducing is the repeated process of combining all elements.
     reduce operation applies a binary operator to each element in the stream where the first argument to the operator
     is the return value of the previous application and second argument is the current stream element.

     {@link } https://www.javabrahman.com/java-8/java-8-reducing-with-streams-reduce-method-tutorial-with-examples/
     * @param stringList
     */
    private static void streamReduce(List<String> stringList) {

        List<Integer> integerList = Arrays.asList(1, 35, 2, 2, 102, 6); //102

        //reduce by calculating sum of elements of a dataSource to one resultant value
        printResult("STREAM RESULT ON INTEGERS");
        Optional<Integer> reduceResult = integerList.stream().reduce((s1, s2) -> s1 + s2);
        // Displaying the resultant String
        reduceResult.ifPresent(System.out::println);


        //reduce by adding separator between all elements of datasource
        printResult("STREAM RESULT OF STRINGS");
        Optional<String> reduceResultOfStrings = stringList.stream().reduce((s1, s2) -> String.valueOf(s1 + "-" + s2));
        //Displaying the resultant String
        reduceResultOfStrings.ifPresent(s -> System.out.println(s));
        //or can be written as
//        reduceResultOfStrings.ifPresent(System.out::println);

        //reduce by given a predicate to a resultant string
        printResult("STEAM RESULT OF STRING - EXAMPLE 2");
        Optional<Integer> resultInteger = integerList.stream().reduce(((s1, s2) -> s1 > s2 ? s1 : s2));
        resultInteger.ifPresent(System.out::println);
        //Expected Result 102

        //reduce by given a predicate to a resultant string
        printResult("STEAM RESULT OF STRING - EXAMPLE 3");
        Optional<String> resultOfString = stringList.stream().reduce(((s1, s2) -> s1.length() > s2.length() ? s1 : s2));
        resultOfString.ifPresent(System.out::println);
        //Expected Result ddd1


    }

    private static void streamCount(List<String> datasource) {
        //counts number of elements that are filtered using Stream
        printResult("STREAM COUNT");
        long filterCount = datasource.stream().filter(s -> s.toLowerCase().startsWith("a")).count();
        printResult("COUNT AFTER FILTERATION " + filterCount);

        //counts number of elements that are filtered using Stream with Multiple Conditions
        printResult("STREAM COUNT");
        long filterCountWithMultipleCondtions = datasource.stream().filter(s -> s.toLowerCase().startsWith("a") || s.toLowerCase().startsWith("b")).count();
        printResult("COUNT AFTER FILTERATION " + filterCountWithMultipleCondtions);

    }

    private static void basicExamples(List<String> datasource) {
        //for each loop alternative way - print datasource elements using forEach
        printResult("STREAM FOREACH");
        datasource.forEach(System.out::println);

        //stream filtering - filter datasource elements starts with "b" using filter
        printResult("STREAM FILTERING");
        datasource.stream().filter(s -> s.startsWith("b")).forEach(System.out::println);

        //stream sorting - Sort datasource in reverse order using sorted
        printResult("STREAM SORTING");
        datasource.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }

    private static void streamMatch(List<String> datasource) {
        //stream anyMatch - Matches an element with datasource's element and returns true if found
        printResult("STREAM ANY-MATCH");
        boolean isMatchFound = datasource.stream().anyMatch(s -> s.startsWith("k"));
        System.out.printf("is Match Found ? %s", isMatchFound);

        //stream AllMatch - Matches an element with all datasource's element and returns true if found
        printResult("");
        printResult("STREAM ALL-MATCH");
        boolean isAllMatchFoundWithA = datasource.stream().allMatch(s -> s.toLowerCase().startsWith("a"));
        System.out.printf("is AllMatch Found ? %s", isAllMatchFoundWithA);

        //stream AllMatch - Matches an element with all datatsource's element and returns true if found ~ With Multiple Conditions/Predicate
        printResult("");
        printResult("STREAM ALL-MATCH WITH MULTIPLE CONDITIONS");
        boolean isAllMatchFoundWithMultpleConditions = datasource.stream().allMatch(s -> s.toLowerCase().startsWith("a") || s.toLowerCase().startsWith("b") ||
                s.toLowerCase().startsWith("c") || s.toLowerCase().startsWith("d"));
        System.out.printf("is AllMatch Found With Multiple Conditions ? %s", isAllMatchFoundWithMultpleConditions);


        //stream NoneMatch - Doesn't match an element
        printResult("");
        printResult("STREAM NONE-MATCH");
        boolean isNoneMatchFound = datasource.stream().noneMatch(s -> s.toLowerCase().startsWith("o"));
        System.out.printf("is NoneMatch Found ? %s", isNoneMatchFound);
        //Expected Result - True, Since "o" doesn't match with any of the elements in DATASOURCE

    }

    private static List<String> loadDatasource() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        return stringCollection;
    }

    private static void printResult(String result) {
        System.out.println(result);
    }
}
