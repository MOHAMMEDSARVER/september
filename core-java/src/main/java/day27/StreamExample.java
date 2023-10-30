package day27;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        Set<Integer> set = list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * e)
                .filter(e -> e % 3 == 0)
                .collect(Collectors.toSet());
        System.out.println(set);
        set.forEach(System.out::println);

        List<Integer> numList=new ArrayList<>(List.of(10,20,30,40,50,60,70,80,90,100));
        int num=50;
        System.out.println(numList.contains(num));


    }
}
