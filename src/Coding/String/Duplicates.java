package Coding.String;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicates {

    public static void main(String[] args) {
        String str = "abcdeabce";
        //Using streams and map
        System.out.println("Output using only Streams -----");
        str.chars().mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1L)
                .forEach((e) -> System.out.println("Character: "+ e.getKey() + " Count: " + e.getValue()));

        //Using set and map
        HashSet<Character> count = new HashSet<>();
        Map<Character,Long> duplicatesCount = new HashMap<>();
        for(char ch: str.toCharArray())
            if (!count.add(ch))
                duplicatesCount.put(ch, duplicatesCount.getOrDefault(ch,1L)+1);
        System.out.println("Output using Set and Map -----");
        duplicatesCount.forEach((k,v) ->
                System.out.println("Character: "+ k + " Count: " + v));

        //Using only map
        duplicatesCount.clear();
        for(char ch: str.toCharArray())
            duplicatesCount.put(ch, duplicatesCount.getOrDefault(ch, 0L) + 1);
        System.out.println("Output using only Map -----");
        for(Map.Entry<Character,Long> entry: duplicatesCount.entrySet())
            if (entry.getValue() > 1L)
                System.out.println("Character: " + entry.getKey() +
                        " Count: " + entry.getValue());

        //without extra space
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        str = new String(charArray);
        int left=0;
        for (int right = 1; right < str.length(); right++) {
            if(str.charAt(left) == str.charAt(right))
                System.out.print(str.charAt(left));
            left++;
        }
        System.out.println();
    }
}


