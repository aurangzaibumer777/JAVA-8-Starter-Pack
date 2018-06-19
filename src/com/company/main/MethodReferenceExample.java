package com.company.main;

/*

 A method reference is a simplified form (or short-hand) of a lambda expression. It specifies the class name or the
 instance name followed by the method name. Instead of writing the lambda expression with all the details such as
 parameter and return type, a method reference lets you create a lambda expression from an existing method implementation.

* Kinds of Method References
There are four kinds of method references:

Kind	                                                                                Example
Reference to a static method	                                                        ContainingClass::staticMethodName
Reference to an instance method of a particular object	                                containingObject::instanceMethodName
Reference to an instance method of an arbitrary object of a particular type	            ContainingType::methodName
Reference to a constructor	                                                            ClassName::new

* */

import java.util.function.Function;

public class MethodReferenceExample {

    public static void main(String[] args){

        exampleStaticMethod();
        exampleInstanceMethod();
        exampleArbitraryObjectInstanceMethod();

        exampleConstructorReference();
    }

    private static void exampleConstructorReference() {
        //Reference to a constructor
        // ClassName::new
        PersonFactory<Person> personFactory;

        //Step 1
        personFactory = new PersonFactory<Person>() {
            @Override
            public Person create(String firstName, String lastName) {
                return new Person();
            }
        };

        //Step 2
        personFactory = (((firstName, lastName) -> new Person(firstName, lastName)));

        //Step 3
        personFactory = Person::new;

        //end Result
        Person person = personFactory.create("Aurangzaib", "Umer");
        System.out.printf("First Name %s And Last Name %s", person.firstName, person.lastName);
    }

    private static void exampleArbitraryObjectInstanceMethod() {
        //Reference to an instance method of an arbitrary object of a particular type
        // ContainingType::methodName
        //Step 1
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        //Step 2
        function = (s -> s.toUpperCase());

        //Step 3
        function = (String::toUpperCase);

        //use Result
        System.out.println(function.apply("gamma"));
    }

    private static void exampleInstanceMethod() {
        //Reference to an instance method of a particular object
        //containingObject::instanceMethodName
        Function<String, String> function;

        //Step 1
        Something something = new Something();
        function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return something.startsWith(s);
            }
        };

        //step 2
        function = (s -> something.startsWith(s));

        //step 3
        function = (something::startsWith);

        //use result
        System.out.println(function.apply("HELLO"));
    }

    private static void exampleStaticMethod() {
        //Reference to a static method
        //ContainingClass::staticMethodName
        Function<String, Integer> function;

        //Traditional Way - Step 1
        function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };

        //to Step 2 - Here s is an string argument
        function = ((s -> Integer.parseInt(s)));

        //to Step 3
        function = (Integer::parseInt);

        //use result
        System.out.println(function.apply("757777"));

    }
}
