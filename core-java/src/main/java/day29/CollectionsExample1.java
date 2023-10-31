package day29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsExample1 {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>();
        names.add("KVR");
        names.add("NVR");
        names.add("GVR");
        names.add("ALN");
        names.add("PKM");
        names.add("MKR");
        Collections.sort(names);
        System.out.println(names);
       // Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);

        List<String> sortedlist=names.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedlist);
    }
}
