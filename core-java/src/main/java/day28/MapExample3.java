package day28;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample3 {
    public static void main(String[] args) {
        Map<String, Integer> ageMap = new HashMap<>();

        ageMap.put("Raju", 25);
        ageMap.put("Krish", 30);
        ageMap.put("Manoj", 25);
        ageMap.put("Charan", 28);
        ageMap.put("Ramakrishna", 35);
        //add rk if not present in the map with 23 age

        ageMap.putIfAbsent("rk", 23);
        System.out.println(ageMap);

        //increase age by 1 if the age is more than 30

        Set<String> keyset = ageMap.keySet();
        for (String ke : keyset) {
            if (ageMap.get(ke) > 30)
                ageMap.put(ke, ageMap.get(ke) + 1);
        }
        System.out.println(ageMap);

    }
}
