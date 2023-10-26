package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 11, 15, 17, 19, 20, 25, 26, 27, 28, 29, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100);
        //all even numbers
        List<Integer> evenlist=filter(list, (integer -> integer%2 == 0));
        System.out.println(evenlist);

        //all prime numbers
        System.out.println("----------------Prime List----------------");
        List<Integer> primlist=filter(list,integer -> isPrime(integer));
        System.out.println(primlist);
        //all numbers between 20 to 50

        System.out.println("------------------numbrs between 20 and 50----------");
        List<Integer> num2050=new ArrayList<>();
        num2050=filter(list,integer -> integer >= 20 && integer <= 50);
        System.out.println(num2050);
        //all numbers divisibel by 5
        System.out.println("-------------numbers divisible by 5 ---------------");
        List<Integer> divisible5 = new ArrayList<>();
        divisible5=filter(list,integer -> integer % 5 == 0);
        System.out.println(divisible5);

    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> result= new ArrayList<>();
        for(Integer i:list){
            if(predicate.test(i))
            {
                result.add(i);
            }
        }
        return result;

    }
}
