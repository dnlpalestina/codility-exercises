package org.example;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Stream;

public class MaxArraySum {

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 8 };
        int maxSum = maxSubArraySum(nums);
        System.out.println("Maximum subarray sum is: " + maxSum);


        TreeSet<String> orderedSet = new TreeSet<>();
        orderedSet.add("A");
        orderedSet.add("b");
        orderedSet.add("A");
        orderedSet.add("3");
        orderedSet.add("B");
        orderedSet.add("a");
        orderedSet.add("1");
        System.out.println(orderedSet);

        ArrayList<String> list = new ArrayList<>(5);


    }

    //Kadane's algorithm
    public static int maxSubArraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
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