package day27;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class SetExample1 {
    public static void main(String[] args) {
        Set<Integer> set=getRandomnumber(20);
        System.out.println(set);
    }

    private static Set<Integer> getRandomnumber(int i) {
        Set<Integer> set=new HashSet<>();
        while ((set.size()!=i))
        {
            set.add(ThreadLocalRandom.current().nextInt(1,i*2));
        }
        return set;
    }
}
