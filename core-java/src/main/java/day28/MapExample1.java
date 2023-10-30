package day28;

import java.util.*;

public class MapExample1 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1001, "RamKrishna");
        map.put(1002, "krish");
        map.put(1003, "megha");
        map.put(1004, "ravi");

        Set<Integer> keylist = map.keySet();
        System.out.println("____________all the keys_________");
        keylist.forEach(System.out::println);

        Collection<String> valueSlist = map.values();
        System.out.println("________________all the values_________");
        valueSlist.forEach(System.out::println);

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        System.out.println("_________________Entry set(key and values together in set)____________");
        entrySet.forEach(e -> {
            System.out.println(e.getKey() + " : " + e.getValue());
        });
        //use of entryset??
    }
}
