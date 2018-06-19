package com.company.main;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*
* As mentioned above streams can be either sequential or parallel. Operations on sequential streams
* are performed on a single thread while operations on parallel streams are performed concurrently
* on multiple threads.
* */
public class ParallelStreamExample {

    private static final int MAX = 1000000;

    public static void main(String[] args){

        List<String> values = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        sequentialSort(values);

        parallelSort(values);
    }

    private static void sequentialSort(List<String> values) {

        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
        //Expected Result : 600 ~ 700 ms
    }

    private static void parallelSort(List<String> values){
        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
        //Expected Result : 350ms ~ 450 ms

    }
}
