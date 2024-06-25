package org.example;

import java.util.Map;
import java.util.HashMap;

public class Fibonacci {
    // HashMap to store previously computed Fibonacci numbers
    private static Map<Integer, Integer> memo = new HashMap<>();

    // Function to return the n-th Fibonacci number
    public static int fibonacci(int n) {
        // Handle the edge case of negative numbers
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci sequence is not defined for negative numbers.");
        }
        if (n <= 1) {
            // Base cases
            return n;
        } else {
            // Check if the value is already in the memo map
            if(memo.containsKey(n)){
                return memo.get(n);
            }
            // Recursive calculation with memoization
            // Sum of the previous two terms
            int result = fibonacci(n - 2) + fibonacci(n - 1);
            memo.put(n,result);
            return result;
        }
    }

    public static void main(String[] args) {
        // Loop to print Fibonacci numbers from 0 to 5
        for (int i = 0; i < 300; i++) {
            System.out.println("i:"+i+"="+fibonacci(i));
        }

        //System.out.println("i:-12="+fibonacci(-12));

    }
}