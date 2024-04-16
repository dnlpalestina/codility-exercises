package org.example;

import java.util.Arrays;
import java.util.stream.Stream;

public class Divisors {

    public static void main(String[] args) {

        System.out.println("Divisors");
        //for every element in the array, calculate how many elements preceding it are it’s divisors
        System.out.println(Arrays.toString(new Divisors().solution(new int[]{2,4,3,6})));
        System.out.println(Arrays.toString(new Divisors().solution(new int[]{1,1,1,1,1})));
        System.out.println(Arrays.toString(new Divisors().solution(new int[]{2,3,5})));
    }

    public int[] solution(int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int divisorCount = 0;
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0) {
                    divisorCount++;
                }
            }
            result[i] = divisorCount;
        }

        return result;
    }
}