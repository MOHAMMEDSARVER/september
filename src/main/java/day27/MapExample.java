package day27;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1001,"Krish");
        map.put(1002,"Manoj");
        map.put(1003,"Charan");
        map.put(1002,"Manoj Kumar");
        System.out.println(map);
        System.out.println(map.get(1002));
        System.out.println(map.get(1004));
    }
}
