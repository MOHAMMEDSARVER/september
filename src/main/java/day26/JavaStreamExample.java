package day26;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        System.out.println("Sum of elements");
        int sum = 0;
        for (int e : list) {
            sum += e;
        }
        System.out.println("Sum is = " + sum);

        double sum1 = list.stream()
                .mapToInt(e -> e)
                .sum();
        System.out.println("sum of numbers using stream " + sum1);

        System.out.println("multipllication of elements using stream");
        List<Integer> newList = list.stream()
                .map(e -> e * e)
                .toList();
        System.out.println(newList);

        // Get elements which are divisible by 3 then multiply by 3 after multiplication get the even numbers
        System.out.println("elements which are divisible by 3 and multiply that number by 3 and get only even numbers");
        List<Integer> mul3list = new ArrayList<>();

        mul3list = list.stream()
                .filter(e -> e % 3 == 0)
                .map(e -> e * 3)
                .filter(e -> e % 2 == 0)
                .toList();
        System.out.println(mul3list);
        List<Integer> filteredList = new ArrayList<>();
        for (Integer ele : list) {
            if (ele % 3 == 0) {
                ele = ele * 3;
                if (ele % 2 == 0) {
                    filteredList.add(ele);
                }
            }
        }
        System.out.println("Traditional way of doing same thing: " + filteredList);


    }
}
