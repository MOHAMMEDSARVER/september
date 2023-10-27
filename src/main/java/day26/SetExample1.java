package day26;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExample1 {
    public static void main(String[] args) {
        List<String> list = List.of("java", "pythone", "php", "java", "pythone");
        System.out.println("list data: " + list);
        //here in list duplicates are allowed so all the elements are present:[java, pythone, php, java, pythone]

        Set<String> set = new HashSet<>(list);
        System.out.println("Set data after adding list data to set: " + set);
        //here in set duplicated are not allowed so only 2 item will be present [java, php, pythone]

        set.forEach(System.out::println);
        for(String name: set) {
            System.out.println(name);
        }

        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            System.out.println(name);
        }

        set.add("php");
        set.addAll(List.of("java","pythone","js"));
        System.out.println(set);
        System.out.println(set.size()!=0);



    }
}
