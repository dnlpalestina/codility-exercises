package org.example;

import java.util.Arrays;
import java.util.List;

public  class ConsecutiveSumExists {
    public static int myInt;

    public static int ConsecutiveSumExistsOrNot(List<Integer> numsArr, int sumValue) {

        {
            myInt = 10;
        }

        int sum = 0;
        int start = 0;

        for (int i = 0; i < numsArr.size(); i++) {
            sum += numsArr.get(i);

            while (sum > sumValue) {
                sum -= numsArr.get(start);
                start++;
            }

            if (sum == sumValue) {
                return start;
            }
        }

        return -1; // If no consecutive sum equals the target
    }

    public static void main(String[] args) {
        System.out.println("myInt = " + ConsecutiveSumExists.myInt);
        List<Integer> nums1 = Arrays.asList(0, 1, 5, 5, 1, 1, 2, 1, 8, 6);
        System.out.println(ConsecutiveSumExistsOrNot(nums1, 7)); // Output: 3

        List<Integer> nums2 = Arrays.asList(0, 1, 5, 5, 45, 1, 2, 1, 2, 6);
        System.out.println(ConsecutiveSumExistsOrNot(nums2, 7)); // Output: -1

        List<Integer> nums3 = Arrays.asList(8, 38, 16, 45, 62, 4, 94, 4, 12, 21, 12, 1, 1, 1, 43, 68, 18, 85, 25, 26);
        System.out.println(ConsecutiveSumExistsOrNot(nums3, 150)); // Output: 5
    }
}
