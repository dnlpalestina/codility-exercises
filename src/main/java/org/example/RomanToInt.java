package org.example;

import java.util.Arrays;

public class CapturingRainwaterTwoPointer {
    public static int captureWaterTwoPointerSolution(int[] heights) {
        int totalWater = 0;
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int leftBound = 0;
        int rightBound = 0;
        while(leftPointer < rightPointer){
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
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] heights = {3,4,1,2,2,5,1,0,2,0,2};
        System.out.println("heights = " + Arrays.toString(heights));
        System.out.println("water = " + captureWaterTwoPointerSolution(heights));
    }
}
