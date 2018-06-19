//package com.company.main;
//
//
//import com.company.interfaces.Converter;
//import com.company.interfaces.EntertainmentListener;
//import com.company.interfaces.EntertainmentMovieListener;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        optionals();
//    }
//
//    private static void optionals(){
//
//        String userName = "";
//        Optional<String> userNameOptional = Optional.of(userName);
//        Optional<String> optional = Optional.of("");
//
////        optional.isPresent();           // true
////        optional.get();                 // "bam"
//        userNameOptional.orElse("fallback");    // "bam"
//
//        optional.ifPresent((s) -> System.out.println(optional.orElse("fallback")));     // "b"
//
//
//    }
//
//    private static void lambdaExpressions(){
//
//        //traditional code
//        //since this interface has multiple abstract methods so lambda cannot be used
//        EntertainmentMovieListener entertainmentMovieListener = new EntertainmentMovieListener() {
//            @Override
//            public int getMovieTypeID() {
//                return 0;
//            }
//
//            @Override
//            public int getMovieName() {
//                return 0;
//            }
//
//            @Override
//            public int getMovieTime() {
//                return 0;
//            }
//        };
//
//        //use of lambda if interface has only one abstract method or declared as Functional Interface
//        EntertainmentListener entertainmentListener = () -> 0;
//
//    }
//
//
//    private void methodAndConstructorReference(){
//        Something something = new Something();
//        Converter<String> converter = something::endsWith;
////        Log.d("methodReference", converter.convert("Java"));
//    }
//
//
//    private void defaultInterface(){
//        EntertainmentListener entertainmentListener = new EntertainmentListener() {
//            @Override
//            public int getViewId() {
//                return 16;
//            }
//        };
//
//        //use of default method in interface, you do not have to write an implementation ~ such methods declared as default
////        Log.d("defaultInterface", entertainmentListener.calculateMaxGameRating(entertainmentListener.getViewId())+"");
//    }
//
//
//    private void comparator(){
//
//        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
//
//        Person p1 = new Person("John", "Doe");
//        Person p2 = new Person("Alice", "Wonderland");
//
//        int nonreversed = comparator.compare(p1, p2);             // > 0
//        int reversed = 0;
//            reversed = comparator.reversed().compare(p1, p2);  // < 0
//
////        Log.d("comparator", nonreversed+" "+reversed);
//    }
//
//    private static void streams(){
//        List<String> stringCollection = new ArrayList<>();
//        stringCollection.add("ddd2");
//        stringCollection.add("aaa2");
//        stringCollection.add("bbb1");
//        stringCollection.add("aaa1");
//        stringCollection.add("bbb3");
//        stringCollection.add("ccc");
//        stringCollection.add("bbb2");
//        stringCollection.add("ddd1");
//
//        stringCollection
//                .stream()
//                .sorted()
//                .findFirst()
//                .ifPresent(System.out::println);  // a1
//    }
//}
