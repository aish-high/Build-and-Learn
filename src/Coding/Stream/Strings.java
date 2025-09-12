package Coding.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Strings {

    public static void main(String[] args) {
        //Given a list of strings, write a program to count the number of strings containing a specific character ‘a’ using Java Stream API.
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
        char searchChar = 'a';
        System.out.println("Number of strings containing 'a' : " +
                strings.stream().filter(s -> s.contains(String.valueOf(searchChar))).count());

        //Write a program to find the longest string in a list of strings using Java Stream API.
        System.out.print("Longest string in a list of strings: ");
        List<String> strings2 = Arrays.asList("apple", "banana", "orange", "grape");
        strings2.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        //Given a String, find the first non-repeated character in it using Stream functions?
        System.out.print("First non-repeated character in a string (using map) : ");
        String input = "Java articles are Awesome";
        input.chars().mapToObj(ch -> Character.toLowerCase((char) ch))
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst().ifPresent(System.out::println);
        //Alternate method
        System.out.print("First non-repeated character in a string (using indexOf()) : ");
        input.chars().mapToObj(c -> Character.toLowerCase((char) c))
                .filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch))
                .findFirst().ifPresent(System.out::println);

        //Given a String, find the first repeated character in it using Stream functions?
        System.out.print("First repeated character in a string (using set) : ");
        HashSet<Character> set = new HashSet<>();
        input.chars().mapToObj(ch -> Character.toLowerCase((char) ch))
                .filter(ch  -> !set.add(ch))
                .findFirst().ifPresent(System.out::println);
        //Alternate method
        System.out.print("First repeated character in a string (using map) : ");
        input.chars()
                .mapToObj(s -> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(Map.Entry::getKey)
                .findFirst().ifPresent(System.out::println);

        //Given a list of strings, write a program to find and print the strings containing duplicate characters using Java Stream API.
        List<String> strings3 = Arrays.asList("apple", "banana", "kiwi", "orange", "pear", "strawberry", "watermelon");
        System.out.print("Strings containing duplicate chars using set: ");
        strings3.stream()
                .filter(s -> {
                    HashSet<Character> set2 = new HashSet<>();
                    return s.chars()
                        .mapToObj(ch -> (char) ch)
                        .anyMatch(ch -> !set2.add(ch));
                })
                .forEach(System.out::print);
        System.out.println();
        System.out.print("Strings containing duplicate chars using length: ");
        strings3.stream()
                .filter(s -> s.length() != s.chars().distinct().count())
                .forEach(System.out::print);
        System.out.println();

        //Write a program to check if all elements in a list of strings are of the same length using Java Stream API.
        List<String> strings4 = Arrays.asList("abc", "abc", "abc");
        System.out.println("Are lengths of all strings same: " +
                strings4.stream().allMatch(str -> str.length() == strings4.getFirst().length()));
        boolean sameLength = strings4.stream()
                .map(String::length)
                .distinct()
                .count() == 1;
        System.out.println("All elements have the same length (option2): " + sameLength);

        //How to count each element/word from the String ArrayList in Java8?
        List<String> list6 = Arrays.asList("AA", "BB", "AA", "CC");
        list6.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((k,v) -> System.out.println("Word: " + k + " Count: " + v));

        // How to find only duplicate elements with its count from the String ArrayList in Java8?
        System.out.println("Duplicate elements using map: ");
        List<String> list7 = Arrays.asList("AA", "BB", "AA", "CC", "CC");
        list7.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1L)
                .forEach(System.out::println);
        System.out.println("Duplicate elements using Collections.frequency(): ");
        list7.stream()
                .filter(str -> Collections.frequency(list7, str) > 1)
                .distinct()
                .forEach(System.out::println);

        //Write a program to print the count of each character in a String?
        System.out.println("Count of each character in a string: ");
        String s = "string data to count each character";
        s.chars().mapToObj(ch -> (char) ch) // Arrays.stream(s.split(""))
                .map(Character::toLowerCase)
                .filter(str -> !str.equals(' '))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k,v) -> System.out.println("Character: " + k + " Count: " + v));

        //Write a program to remove all whitespace from a list of strings using Java Stream API.
        List<String> strings5 = Arrays.asList("apple", "ba nana", "kiwi", "oran ge", "pear");
        System.out.println("After removing whitespaces: ");
        strings5.stream().map(st -> st.replaceAll("\\s", "")).forEach(System.out::println);

        //Given a list of strings, write a program to find and print the strings with the maximum number of vowels using Java Stream API.
        System.out.println("Strings with maximum number of vowels: ");
        List<String> strings6 = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        Map<String, Long> frequencyMap = strings6
                .stream()
                .collect(Collectors.toMap(Function.identity(), i -> i.chars().mapToObj(ch -> (char) ch)
                        .filter(ch -> "aeiou".contains(String.valueOf(ch))).count()));
        Long maxFrequency = frequencyMap.values().stream().mapToLong(Long::longValue)
                .max().orElse(0L);
        frequencyMap.entrySet().stream()
                .filter(e -> Objects.equals(e.getValue(), maxFrequency))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        //Given a list of strings, write a program to find and print the strings containing a specific character at least twice using Java Stream API.
        System.out.println("Strings containing a specific char at least twice: ");
        char targetChar = 'a';
        strings6.stream().collect(Collectors.toMap(Function.identity(),
                i -> i.chars().mapToObj(ch -> (char) ch).filter(ch -> targetChar == ch).count()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue()>=2L)
                .forEach(System.out::println);

        //Given a list of strings, write a program to find and print the strings with the maximum number of consonants using Java Stream API.
        System.out.println("Strings with maximum number of consonants: ");
        Map<String, Long> frequencyMap2 = strings6
                .stream()
                .collect(Collectors.toMap(Function.identity(), i -> i.chars ().mapToObj(ch -> (char) ch)
                        .filter(ch -> !"aeiou".contains(String.valueOf(ch))).count()));
        Long maxFrequency2 = frequencyMap2.values().stream()
                .max(Comparator.comparingLong(n->n)).orElse(0L);
        frequencyMap2.entrySet().stream()
                .filter(e -> Objects.equals(e.getValue(), maxFrequency2))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        //Write a program to check if a list of strings is palindrome using Java Stream API.
        List<String> strings7 = Arrays.asList("apple", "banana", "kiwi", "banana", "apple");
        boolean isPalindrome = strings7.stream()
                .skip(strings7.size() / 2)
                .allMatch(str -> str.equals(strings7.get(strings7.size() - 1 - strings7.indexOf(str))));
        System.out.println("Is the list of strings a palindrome: " + isPalindrome);

        //Write a program to remove all non-numeric characters from a list of strings using Java Stream API.
        System.out.println("List of strings after removing non-numerics: ");
        List<String> strings8 = Arrays.asList("a1b2c3", "1a2b3c", "123abc");
        strings8.stream().map(n-> n.chars().mapToObj(ch -> (char) ch)
                .filter(ch -> ch.toString().matches("[0-9]+"))
                .map(ch -> ch + "")
                .collect(Collectors.joining()))
                .forEach(System.out::println);
        //Alternate
        Pattern pattern = Pattern.compile("[^0-9]");
        System.out.println("List with non-numeric characters removed (using Pattern): " + strings8.stream()
                .map(ss -> pattern.matcher(ss).replaceAll("")).toList());
    }
}
