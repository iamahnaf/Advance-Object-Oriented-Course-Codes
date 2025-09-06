package HashMap;

import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        Map<String,Integer> numbers = new HashMap<>();
        numbers.put("one",1);
        numbers.put("two",2);
        numbers.put("three",3);

        numbers.putIfAbsent("two",233);


        System.out.println(numbers);

//        for(Map.Entry<String,Integer> e: numbers.entrySet()){
//            System.out.println(e.getKey());
//            System.out.println(e.getValue());
//        }

//        for(String key: numbers.keySet()){
//            System.out.println(key);
//        }
//        for(Integer value: numbers.values()){
//            System.out.println(value);
//        }

        System.out.println(numbers.containsKey("one"));
        System.out.println(numbers.isEmpty());
    }
}
