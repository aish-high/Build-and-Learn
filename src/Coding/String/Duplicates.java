package Coding.String;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicates {

    public static void main(String[] args) {
        String str = "abcdeabce";
        str.chars().mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1L)
                .forEach((e) ->
                        System.out.println("Character: "+ e.getKey() + " Count: " + e.getValue()));

        HashSet<Character> count = new HashSet<>();
        Map<Character,Long> duplicatesCount = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if (!count.add(ch))
                duplicatesCount.put(ch, duplicatesCount.getOrDefault(ch,1L)+1);
        }
        duplicatesCount.forEach((k,v) ->
                System.out.println("Character: "+ k + " Count: " + v));

    }
}


