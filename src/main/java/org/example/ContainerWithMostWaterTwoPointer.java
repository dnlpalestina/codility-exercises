package org.example;

public class ContainerWithMostWaterTwoPointer {

    // Return the most water that could be contained by two of the delimiter walls provided
    static int getMostWaterArea(int[] heights) {
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int mostWaterArea = 0;

        // until either our pointers meet (in which case we did not find a successful pair)
        // or until we find a pair of walls that could hold the most water
        while(leftPointer < rightPointer){
            int width = rightPointer-leftPointer;
            int currentMinHeight = Math.min(heights[leftPointer],heights[rightPointer]);//height of the shorter wall
            int currentMostWaterArea = width*currentMinHeight;

            mostWaterArea = Math.max(mostWaterArea, currentMostWaterArea);

            // All other containers ending at the right pointer hold a smaller amount of water than our current container,
            // so we eliminate them from our search by moving the right pointer.
            if(heights[leftPointer]<heights[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return mostWaterArea;
    }
    public static void main(String[] args) {
        System.out.println(getMostWaterArea(new int[]{3,4,1,2,2,4,1,3,2}));
    }
}
