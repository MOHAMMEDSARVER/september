package day25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProcessingElementsFromList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("pythone");
        list.add(".net");
        list.add("php");
      //  list.add("JavaScript");


        //Using for loop
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i));
        }

        //Using for Each loop
        for (String ele : list) {
            // System.out.println(ele);
        }

        //Using forEach Method
        // list.forEach(s -> System.out.println(s)); or
        // list.forEach(System.out::println);


        //Using Iterator
        //here by using iterator we can even remove items for the list. every collection class implements itertor interface
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
            if (i.next().equals("pythone")) {
                i.remove();
                break;
            }
        }
        System.out.println("-------------------Using Consumer---------------");
        //here only half will be printed because we are using same iterator object so half will be printed earlier
        //Using Consumer interface
        i.forEachRemaining(ele -> {
            System.out.println(i.next());
        });
        System.out.println("-----------------------------------------ListIterator--------------------");
        //Using ListIterator -> we can use only with the listimplemented classes
        //it has some more functionnalities like traversing both direction,remove ,add ,replace by using set etc.

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String ele= listIterator.next();
            System.out.println(ele);
            if (ele.equals("java")) {
                listIterator.remove();
            }
        }

        //System.out.println("----------------------ListIteratorHas Previous----------");
       /* while (listIterator.hasPrevious()){
            String ele=listIterator.previous();
            if(ele.equals("JavaScript"))
                listIterator.add("ReactJs");
            if(ele.equals("pythone"))
                listIterator.set("pythone-3-2");
            System.out.println(ele);
        }*/


    }

    interface  I1{
        I2 getI2();
    }
    interface  I2{
        boolean isEven(int num);
    }
    class  C1 implements I1{

        @Override
        public I2 getI2() {
            return new X();
        }

        class X implements  I2{
            @Override
            public boolean isEven(int num) {
                return num % 2 == 0;
            }
        }

    }
}
