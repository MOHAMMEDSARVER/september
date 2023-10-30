package day26;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
        List<Integer> wordLengths = getWordsLength(words);
        System.out.println(wordLengths);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenSquareList = numbers.stream()
                .filter(e -> {
                    System.out.println("filtering " + e);
                    return e % 2 == 0;
                })
                .map(e -> {
                    System.out.println("Mapping of " + e);
                    return e * e;
                })
                .limit(2).toList();
        System.out.println("even number squares :" + evenSquareList);
    }

    private static List<Integer> getWordsLength(List<String> words) {
       /* List<Integer> woldlength = words.stream()
                .map(e -> e.length())
                .toList();
        return woldlength;*/
        //or we can use below cod

        return words.stream()
                .map(String::length)
                .toList();

    }
}
