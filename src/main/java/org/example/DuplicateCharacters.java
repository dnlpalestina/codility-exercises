package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateCharacters {
    public static HashMap<Character, Integer> findDuplicateCharacters(String string){
        HashMap<Character, Integer> duplicateCharacters = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            int count = duplicateCharacters.getOrDefault(string.charAt(i), 0);
            duplicateCharacters.put(string.charAt(i), count+1);
        }

        Map<Object, Long> duplicateCharactersViaStream = new HashMap<>();
        duplicateCharactersViaStream = string.chars()
                .mapToObj(c->c)
                .collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()));

        return duplicateCharacters;
    }

    public static void main(String[] args){
        HashMap<Character, Integer> duplicateCharacters;
        String string = "QWERWERWErwerwerweryewrwerttewrtretreyertytretyerrereewewewe";
        System.out.println("string = " + string);
        duplicateCharacters = findDuplicateCharacters(string);
        System.out.println(duplicateCharacters.toString());


    }
}
