package day25;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AssignmentQuestions {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // Get the sum of all elements
        int sum = 0;
        for (int ele : list) {
            sum += ele;
        }
        System.out.println("sume of list elements are: " + sum);
        System.out.println("______________________________________________________________");

        // Get elements which are divisible by 3
        System.out.println("Elements which are divisible by 3");
        list.forEach(s -> {
            if (s % 3 == 0)
                System.out.println(s);
        });
        System.out.println("______________________________________________________________");

        // Get another list which contains square of all elements
        List<Integer> squarlist = new ArrayList<>();
        list.forEach(s -> {
            squarlist.add(s * s);
        });
        System.out.println("Square of all elements " + squarlist);
        System.out.println("______________________________________________________________");


        // Get another list which contains only even numbers
        List<Integer> evenlist = new ArrayList<>();
        list.forEach(s -> {
            if (s % 2 == 0)
                evenlist.add(s);
        });
        System.out.println("Evenlist: " + evenlist);
        System.out.println("______________________________________________________________");

        // Get another list which contains only odd numbers
        List<Integer> oddlist = new ArrayList<>();
        list.forEach(s -> {
            if (!(s % 2 == 0))
                oddlist.add(s);
        });
        System.out.println("Odd elements list is : " + oddlist);
        System.out.println("______________________________________________________________");


        // replace all the even number with 10
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            int ele = listIterator.next();
            if (ele % 2 == 0)
                listIterator.set(10);
        }
        System.out.println("list after setting even number to 10:  " + list);
        System.out.println("______________________________________________________________");


        // Get another list which contains only prime numbers
        List<Integer> primelist = new ArrayList<>();
        list.forEach(s -> {
            if (isprime(s))
                primelist.add(s);
        });
        System.out.println("prime numbers list :"+primelist);
        System.out.println("______________________________________________________________");
        ;
    }

    private static boolean isprime(Integer s) {
        for (int i = 2; i < s / 2; i++) {
            if (s % i == 0)
                return false;
        }
        return true;

    }
}
