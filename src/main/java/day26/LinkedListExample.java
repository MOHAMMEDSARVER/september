package day26;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        list.add("java");
        list.add("pythone");
        list.add("php");
        list.add("sql");
        System.out.println(list);
        System.out.println("first element :"+list.getFirst());
        System.out.println("Last element :"+list.getLast());
        list.addFirst("RUST");
        System.out.println("after adding first element :"+list);
    }
}
