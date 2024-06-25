package org.example;

import java.util.HashMap;
import java.util.Map;

public class IsAFibonacci {

    // HashMap to store previously computed Fibonacci numbers
    private static Map<Integer, Integer> memo = new HashMap<>();
    private static Map<Integer, Integer> fibSequence = new HashMap<>();


    // Function to return the n-th Fibonacci number
    public static int fibonacci(Integer n) {
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
                System.out.println(memo.get(n));
                fibSequence.put(memo.get(n), n);
                return memo.get(n);
            }
            // Recursive calculation with memoization
            // Sum of the previous two terms
            Integer result = fibonacci(n - 2) + fibonacci(n - 1);
            memo.put(n,result);
            fibSequence.put(result, n);
            System.out.println("result = " + result);
            return result;
        }
    }

    public static boolean isFibonacci(Integer n){

        Integer fibonacciNumber = fibonacci(n);
        System.out.println("fibonacciNumber = " + fibonacciNumber);

        for (Map.Entry<Integer, Integer> entry : fibSequence.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Check if the value is already in the memo map
        if(fibSequence.containsKey(n)){
            System.out.println("Value: " + fibSequence.get(n));
            System.out.println("Equals!!!");
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(isFibonacci(6));
    }
}
