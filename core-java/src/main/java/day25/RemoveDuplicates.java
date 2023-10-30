package day25;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = List.of(1, 2, 5, 6, 7, 8, 9, 10);

        List<Integer> list3 = new ArrayList<>();

        for (Integer ele : list1) {
            if (!list3.contains(ele))
                list3.add(ele);
        }
        for (Integer ele : list2) {
            if (!list3.contains(ele))
                list3.add(ele);
        }
        System.out.println(list3);
    }
}
