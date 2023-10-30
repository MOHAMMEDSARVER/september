package day27;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetExampleWithLinkedHashSet {
    public static void main(String[] args) {
        //here linked hashset is used to maintain insertion order wheras the Hashset will not maintain insertion order
        Set<String> lset=new LinkedHashSet<>();
        lset.add("java");
        lset.add("python");
        lset.add("php");
        lset.add("js");
        System.out.println(lset);
    }
}
