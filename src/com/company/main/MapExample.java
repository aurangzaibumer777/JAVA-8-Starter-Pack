package com.company.main;


import java.util.HashMap;
import java.util.Map;

/*
* As already mentioned maps do not directly support streams. There's no stream() method available on the Map
* interface itself, however you can create specialized streams upon the keys,
* values or entries of a map via map.keySet().stream(), map.values().stream() and map.entrySet().stream().
* */
public class MapExample {

    public static void main(String[] args){

        Map<Integer, String> map = new HashMap<>();

        /*
        * put method inserts the element ( key value pair ) into the Map. If the Map already contains an element with the same Key,
        * the value is overwritten with the new element value.

        putIfAbsent performs the check to see if the same Key already existed in the Map and will only add a new element
        if it's not already there or present ( Match by the Key )

        * */
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        System.out.println(map.get(3));

        computIfPresent(map);

        computeIfAbsent(map);

        remove(map);

        getOrDefault(map);

        merge(map);



    }

    private static void merge(Map<Integer, String> map) {
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));             // val9

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));              // val9concat
    }

    private static void getOrDefault(Map<Integer, String> map) {
        //returns a default value if value doesnt exist on desired Key
        map.getOrDefault(42, "not found");  // not found
    }

    private static void remove(Map<Integer, String> map) {
        //this will remove entries for a given key, only if it's currently mapped to a given value:
        map.remove(3, "val3");
        map.get(3);             // val33

        map.remove(3, "val33");
        map.get(3);             // null
    }

    private static void computeIfAbsent(Map<Integer, String> map) {
        //if we already put a value @ key 23 and try to compute the value again from the same key
        // and update the value, it wont happen like below
        map.put(23, "val124");

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23));    // true
        System.out.println(map.get(23));        //Expected Result val124 though the latest value put on 23 was "val23" which wasn't computed
    }

    private static void computIfPresent(Map<Integer, String> map) {
        //get value from key (3) and append/update the value = value + key
        map.computeIfPresent(3, (num, val) -> val + num);

        System.out.println(map.get(3));             //Expected RESULT val33

        //get value from key (3) and append/update the value = null
        map.computeIfPresent(9, (num, val) -> null);

        System.out.println(map.containsKey(9));     //Expected RESULT false


    }
}
