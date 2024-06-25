package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class FruitCounter {
    public static HashMap<String, Integer> fruitCounter(List<String> list){
        HashMap<String, Integer> fruitsCounts = new HashMap<>();

        for (String fruit : list) {
            int count = fruitsCounts.getOrDefault(fruit, 0);
            fruitsCounts.put(fruit, count + 1);
        }

        Map<Object, Long> fruitCountViaStreams = list
                .stream()
                .collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()));

        System.out.println(fruitCountViaStreams.toString());

        return fruitsCounts;
    }

    public static void main(String[] args){
        HashMap<String, Integer> fruitsCounts = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("Mango");
        list.add("Mango");
        list.add("Mango");
        list.add("Apple");
        list.add("Sandia");
        list.add("Fresa");
        list.add("Fresa");
        list.add("Sandia");

        System.out.println(list.toString());
        fruitsCounts = fruitCounter(list);
        System.out.println(fruitsCounts.toString());


    }
}
