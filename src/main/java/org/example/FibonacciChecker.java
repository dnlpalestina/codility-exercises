package org.example;

public class FibonacciChecker {

    // Helper function to check if a number is a perfect square
    private static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    // Function to check if a given number is a Fibonacci number
    public static boolean isFibonacci(int n) {
        // Check if one or both of 5n^2 + 4 or 5n^2 - 4 is a perfect square
        int x1 = 5 * n * n + 4;
        int x2 = 5 * n * n - 4;

        return isPerfectSquare(x1) || isPerfectSquare(x2);
    }

    public static void main(String[] args) {
        // Test the function with some examples
        int[] testNumbers = {0, 1, 2, 3, 4, 5, 8, 13, 21, 34, 55, 89, 144, 233};

        for (int num : testNumbers) {
            System.out.println(num + " is Fibonacci? " + isFibonacci(num));
        }

        // Test with a non-Fibonacci number
        int nonFibo = 100;
        System.out.println(nonFibo + " is Fibonacci? " + isFibonacci(nonFibo));
    }
}