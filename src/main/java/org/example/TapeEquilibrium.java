package org.example;

import java.util.Arrays;

public class TapeEquilibrium {

    public static void main(String[] args) {
        System.out.println("min = " + new TapeEquilibrium().solution(new int[]{3,1,2,4,3}));
        System.out.println("min = " + new TapeEquilibrium().solution(new int[]{1000, -1000}));
    }

    public int solution(int[] A){
        int totalSum = Arrays.stream(A).sum(); // Calculate total sum of the array

        int leftSum = 0; // Initialize left sum
        int minDifference = Integer.MAX_VALUE; // Initialize minimum absolute difference

        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i]; // Add current element to the left sum
            int rightSum = totalSum - leftSum; // Calculate right sum

            int difference = Math.abs(leftSum - rightSum); // Calculate the absolute difference

            if (difference < minDifference) {
                minDifference = difference; // Update minimum absolute difference
            }
        }

        return minDifference;
    }
}