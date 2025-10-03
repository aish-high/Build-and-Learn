package Coding.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {

    public static void main(String[] args) {
        //Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
        System.out.println("Even numbers in a list:");
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        list.stream().filter(n -> n%2==0).forEach(System.out::println);

        /* When numbers are given as Array int[] arr = {10,15,8,49,25,98,32}; */
        System.out.println("Even numbers (int[]) :");
        int[] arr = {10,15,8,49,25,98,32};
        Arrays.stream(arr).boxed().filter(n -> n%2==0).forEach(System.out::println);

        //Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        System.out.println("Numbers starting with 1:");
        List<Integer> list2 = Arrays.asList(10,15,8,49,25,98,32);
        list2.stream().map(Object::toString)
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);

        /* When numbers are given as Array int[] arr = {10,15,8,49,25,98,32}; */
        System.out.println("Numbers starting with 1 (int[]) :");
        int[] arr2 = {10,15,8,49,25,98,32};
        Arrays.stream(arr2).boxed().map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);

        //How to find duplicate elements in a given integers list in java using Stream functions?
        System.out.println("Duplicate elements in integer list: ");
        List<Integer> list3 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        list3.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue()>1L)
                .forEach(e->System.out.println(e.getKey()));

        /* Find distinct integers When numbers are given as Array int[] arr = {10,15,8,49,25,98,98,32,15}; */
        System.out.println("Distinct values in a list:");
        int[] arr3 = {10,15,8,49,25,98,98,32,15};
        Arrays.stream(arr3).boxed().distinct()
                .forEach(System.out::println);

        //Given the list of integers, find the first element of the list using Stream functions?
        System.out.print("First element in a list: ");
        List<Integer> list4 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        list4.stream().findFirst().ifPresent(System.out::println);

        //Given a list of integers, find the maximum value element present in it using Stream functions?
        System.out.print("Maximum value of an integer list: ");
        List<Integer> list5 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        list5.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

        //Given an integer array numbers, return true if any value appears at least twice in the array, and return false if every element is distinct.
        int[] arr4 = {1,2,3,1};
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Does any value appear at least twice: " + Arrays.stream(arr4)
                .anyMatch(num -> !set2.add(num)));

        //Given a list of integers, write a program to find and print the second-largest number using Java Stream API.
        System.out.print("Second-largest number in a list: ");
        List<Integer> numbers = Arrays.asList(4, 2, 8, 6, 10);
        numbers.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).forEach(System.out::println);

        //Write a program to find the product of all elements in a list of integers using Java Stream API.
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Product of all elements in a list: " + numbers2.stream().reduce(1, (i,j) -> i*j));

        //Write a Program to find the Maximum element in an array?
        int[] arr5 = {1,2,3,1};
        System.out.println("Maximum element in an array: " + Arrays.stream(arr5).max().getAsInt());

        //Given a list of integers, write a program to find and print the difference between the maximum and minimum numbers using Java Stream API.
        System.out.println("Difference between min and max: " +
                (numbers.stream().max(Comparator.naturalOrder()).get() - numbers.stream().min(Comparator.naturalOrder()).get()));

        //Write a program to check if a list of integers is sorted in ascending order using Java Stream API.
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 3);
        System.out.println("Is list sorted?: " + numbers3.stream().sorted().toList().equals(numbers3));

        /* Given an Integer List, Write a generic code to find all the numbers nearest/closest to 25.Assume 25 is the target number and won't be present in the list.
         * Test Case 1 : List<Integer> numberList1 = Arrays.asList(45,67,11,22,24,78,29,26); Output : 24,26
         * Test Case 2 : List<Integer> numberList2 = Arrays.asList(45,67,11,22,23,78,29,26); Output : 26
         * Test Case 3 : List<Integer> numberList3 = Arrays.asList(45,67,11,21,13,78,29,16); Output : 21,29 */
        List<Integer> numbers4 = Arrays.asList(45, 67, 11, 21, 13, 78, 29, 16);
        int minDiff = numbers4.stream()
                .mapToInt(n -> Math.abs(n - 25))
                .min()
                .orElse(Integer.MAX_VALUE);
        numbers4.stream()
                .filter(n -> Math.abs(n - 25) == minDiff)
                .toList().forEach(System.out::println);

        //How to find the common elements from two arrays using flatmap in java 8
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {3, 4, 5, 6, 7};
        Integer[] result = Arrays.stream(array1)
                .flatMap(x->Arrays.stream(array2)
                .filter(y -> y.equals(x)))
                .distinct()
                .toArray(Integer[]::new);
        System.out.println("Common elements from two arrays: "+ Arrays.toString(result));

        //How to find common elements in three sorted arrays using java 8
        int[] arr6 = {1, 3, 4};
        int[] arr7 = {2, 3, 5, 7, 8};
        int[] arr8 = {3, 7, 9};
        System.out.print("Common elements from three sorted arrays: ");
        Arrays.stream(arr6).boxed()
                .flatMap(x-> Arrays.stream(arr7).boxed()
                .filter(y -> y.equals(x) && Arrays.stream(arr8).boxed().anyMatch(z -> z.equals(x))))
                .distinct().forEach(System.out::println);
        //alternate approach
        Set<Integer> set3 = Arrays.stream(arr6).boxed().collect(Collectors.toSet());
        Set<Integer> set4 = Arrays.stream(arr7).boxed().collect(Collectors.toSet());
        Set<Integer> set5 = Arrays.stream(arr8).boxed().collect(Collectors.toSet());
        set3.retainAll(set4);
        set3.retainAll(set5);

        //Given an array of integers, write a Java 8 program using stream to find the product of all the elements except the current element.
        int product = Arrays.stream(arr6).reduce(1,(i,j) -> i*j);
        Arrays.stream(arr6).map(n -> product/n).forEach(System.out::println);
    }
}
