package org.example;

import java.util.stream.Stream;

public class Divisors {

    public static void main(String[] args) {
        int number = 529;
        System.out.println("normal Solution:");
        System.out.println(new Divisors().solution(number));
        System.out.println("lambdas and streams Solution:");
        System.out.println(new Divisors().functionalProgSolution(number));
    }

    public int solution(int N) {
        // Get the binary representation as an array
        String binaryRepresentation = Integer.toBinaryString(N);
        System.out.println("binaryRepresentation = " + binaryRepresentation);

        int maxLength = 0;
        int currentLength = 0;
        boolean started = false;
        for (int i = 0; i < binaryRepresentation.length(); i++) {
            if (binaryRepresentation.charAt(i) == '1') {
                if (started) {
                    maxLength = Math.max(maxLength, currentLength);
                }
                currentLength = 0;
                started = true;
            } else if (binaryRepresentation.charAt(i) == '0') {
                currentLength++;
            }
        }
        return maxLength;
    }

    public int functionalProgSolution(int N) {
        // Get the binary representation as an array
        String binaryRepresentation = Integer.toBinaryString(N);
        System.out.println("binaryRepresentation = " + binaryRepresentation);
        Stream.of(binaryRepresentation.split("1")).forEach(System.out::println);
        // Split the binary representation by '1's, remove trailing zeros, and find the length of each part
        return Stream.of(binaryRepresentation.split("1"))
                .filter(part -> !part.isEmpty()) // Remove trailing zeros
                .mapToInt(String::length) // Map each part to its length
                .max() // Find the maximum length
                .orElse(0);
    }
}