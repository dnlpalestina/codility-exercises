package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedChar {
    public static void main(String[] args){

        //Como saber si en este stream cual es el caracter mas repetido?
        String input = "aaabbbbcccccaaaaaaacbbbaceccddeeeejjkjaass";
        System.out.printf("input: %s",input);
        System.out.println();
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            charFrequency.put(c, charFrequency.getOrDefault(c,0)+1);
        }

        char mostRepeatedChar = ' ';
        int maxRepeats = 0;

        for (Map.Entry<Character,Integer> entry: charFrequency.entrySet()){
            if(entry.getValue()>maxRepeats){
                mostRepeatedChar  = entry.getKey();
                maxRepeats = entry.getValue();
            }
        }
        System.out.println("mostRepeatedChar = " + mostRepeatedChar);
        System.out.println("maxRepeats = " + maxRepeats);

        Map<Character, Long> charFrequency2 = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map.Entry<Character, Long> entry = charFrequency2.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        char mostRepeatedChar2 = (entry!=null) ? entry.getKey() : ' ';
        long maxRepeats2 = (entry!=null) ? entry.getValue() : 0;
        System.out.println("mostRepeatedChar2 = " + mostRepeatedChar2);
        System.out.println("maxRepeats2 = " + maxRepeats2);



    }
}
