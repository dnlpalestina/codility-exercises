package org.example;

import java.util.Arrays;

public class CapturingRainwater {
    public static int captureWaterTwoPointerSolution(int[] heights) {
        int totalWater = 0;
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int leftBound = 0;
        int rightBound = 0;
        while(leftPointer < rightPointer){
//            System.out.println("Before!");
//            System.out.println("leftPointer = " + leftPointer);
//            System.out.println("leftBound = " + leftBound);
//            System.out.println("rightPointer = " + rightPointer);
//            System.out.println("rightBound = " + rightBound);
//            System.out.println("totalWater = " + totalWater);


            //if the element at leftPointer <= the element at rightPointer:
            if ( heights[leftPointer] <= heights[rightPointer] ){
                leftBound = Math.max(heights[leftPointer], leftBound);
                totalWater += leftBound - heights[leftPointer];
                leftPointer++;
            } else {
                rightBound = Math.max(heights[rightPointer], rightBound);
                totalWater += rightBound - heights[rightPointer];
                rightPointer--;
            }
//            System.out.println("After!");
//            System.out.println("leftPointer = " + leftPointer);
//            System.out.println("leftBound = " + leftBound);
//            System.out.println("rightPointer = " + rightPointer);
//            System.out.println("rightBound = " + rightBound);
//            System.out.println("totalWater = " + totalWater);
        }
        return totalWater;
    }

    public static int captureWaterNaiveSolution(int[]heights) {
        int totalWater = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int leftBound = 0;
            int rightBound = 0;
            // Here we only want to look at elements to the LEFT of index i, which are the elements at the lower indices
            for (int j = 0; j <= i; j++) {
                leftBound = Math.max(leftBound, heights[j]);
            }
            // Now here we only want to look at elements to the RIGHT of index i, which are the elements at the higher indices
            for (int j = i; j < heights.length; j++) {
                rightBound = Math.max(rightBound, heights[j]);
            }
            // Add the amount of water at index i to totalWater
            totalWater += Math.min(leftBound, rightBound) - heights[i];
            System.out.println("i = " + i + " water = " + (Math.min(leftBound, rightBound) - heights[i]));
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 1, 3, 0, 1, 2};
        System.out.println("heights = " + Arrays.toString(heights));
        System.out.println("water = " + captureWaterNaiveSolution(heights));


        System.out.println("heights = " + Arrays.toString(heights));
        System.out.println("water = " + captureWaterTwoPointerSolution(heights));
    }
}
