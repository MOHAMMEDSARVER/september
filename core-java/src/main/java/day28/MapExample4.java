package day28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;
import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public class MapExample4 {
    public static void main(String[] args) {
        //find the occurance of each word in the string
        String data = "Java,Python,Python,.Net,Java,Angular,React,Angular,Java,.Net,Java,Angular";
        String[] words = data.split(",");

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordCountMap);

        //now by using streams
        Map<String, Long> map = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //here words is array not list so we use arrays.stream

        //what is collect and collectors

        System.out.println(map);


    }
}
