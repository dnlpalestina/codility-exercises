package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleTripletsTwoPointer {
    public static int getTriplets(int[] nums){
        Arrays.sort(nums);
        BubbleSort.bubbleSort(nums);
        int countResult = 0;

        for (int i = nums.length-1; i > 1; i--) {
            int leftPointer = 0;
            int rightPointer = i-1;
            while (leftPointer<rightPointer){
                if(nums[leftPointer]+nums[rightPointer]>nums[i]){
                    System.out.println("Main Combination = "
                            + Arrays.toString(new int[]{nums[leftPointer], nums[rightPointer], nums[i]}));
                    System.out.println("leftPointer = " + leftPointer);
                    System.out.println("rightPointer = " + rightPointer);
                    countResult += rightPointer-leftPointer;
                    rightPointer--;
                }else {
                    leftPointer++;
                }
            }
        }
        return countResult;
    }
    public static void main(String[] args) {
        int[] nums = {11,4,9,6,15,18};
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("triplets = " );
        System.out.println("getTriplets(nums) = " +
                "" + getTriplets(nums));
    }
}
