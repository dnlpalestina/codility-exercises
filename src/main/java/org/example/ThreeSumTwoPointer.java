package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSumTwoPointer {
    public static List<int[]> getTriplets(int[] nums){
        Arrays.sort(nums);
        BubbleSort.bubbleSort(nums);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {

            if (i>0 && nums[i]==nums[i-1])
                continue;

            int leftPointer = 0;
            int rightPointer = nums.length - 1;
            while(leftPointer<rightPointer){

                int total = nums[i]+nums[leftPointer]+nums[rightPointer];

                if (total<0) {
                    leftPointer++;
                } else if (total>0){
                    rightPointer--;
                } else {
                    result.add( new int[]{ nums[i], nums[leftPointer], nums[rightPointer] } );
                    while (leftPointer<rightPointer && nums[leftPointer]==nums[leftPointer+1]){
                        leftPointer++;
                    }
                    while (leftPointer<rightPointer && nums[rightPointer]==nums[rightPointer-1]){
                        rightPointer--;
                    }
                    leftPointer++;
                    rightPointer--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-1};
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("triplets = " );
        getTriplets(nums)
                .stream()
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
