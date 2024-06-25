package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        boolean isAnagram=true;
        if (a.length()!=b.length()) {
            isAnagram=false;
            return isAnagram;
        }

        //calculate char frequency for each input string
        Map<Character, Integer> charFrequencyA = new HashMap<>();
        Map<Character, Integer> charFrequencyB = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char cA = a.charAt(i);
            char cB = b.charAt(i);
            int countA = charFrequencyA.getOrDefault(cA, 0);
            int countB = charFrequencyB.getOrDefault(cB, 0);
            charFrequencyA.put(cA, countA+1);
            charFrequencyB.put(cB, countB+1);
        }

        System.out.println("charFrequencyA = " + charFrequencyA.toString());
        System.out.println("charFrequencyB = " + charFrequencyB.toString());

        //compare char frequencies
        for (Map.Entry<Character, Integer> entry: charFrequencyA.entrySet()) {
            if(!Objects.equals(entry.getValue(), charFrequencyB.get(entry.getKey()))){
                isAnagram=false;
                break;
            }
        }
        return isAnagram;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
