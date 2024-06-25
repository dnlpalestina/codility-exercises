package org.example;

import java.util.Arrays;
import java.util.List;

public class TwoSumIndexesTwoPointer {

    // Return the indices of the numbers in the source list that add up to target
    static List<Integer> getIndices(int[] array, int target) {
        int leftPointer = 0;
        int rightPointer = array.length - 1;

        // until either our pointers meet (in which case we did not find a successful pair)
        // or until we find a pair that sums to our target
        while(leftPointer < rightPointer){

            int currentSum = array[leftPointer] + array[rightPointer];
            if(currentSum==target){
                return Arrays.asList(leftPointer, rightPointer);
            } else if (currentSum<target) { //all other pairs involving our left pointer also have sums less than our target
                leftPointer++;
            } else { //all other pairs ending at our right pointer also have sums greater than our target
                rightPointer--;
            }

        }

        return Arrays.asList(-1,-1);
    }
    public static void main(String[] args) {
        System.out.println(getIndices(new int[]{1, 3, 4, 6, 8, 10, 13}, 13));
        System.out.println(getIndices(new int[]{2,3,4,5,7,7,8,9,17,13,19,55}, 24));
    }
}
