package org.example;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static int getRomanToInt(String roman) {
        int result = 0
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < roman.length(); i++) {
            if (i<roman.length()-1 && map.get(roman.charAt(i))<map.get(roman.charAt(i+1))){
                result -= map.get(roman.charAt(i));
            } else {
                result += map.get(roman.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String roman = "IX";
        System.out.println("roman = " + roman);
        System.out.println("getRomanToInt(roman) = " + getRomanToInt(roman));

        roman = "XI";
        System.out.println("roman = " + roman);
        System.out.println("getRomanToInt(roman) = " + getRomanToInt(roman));

        roman = "MD";
        System.out.println("roman = " + roman);
        System.out.println("getRomanToInt(roman) = " + getRomanToInt(roman));
    }
}
