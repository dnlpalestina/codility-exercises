package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class peakElements {
    public static int[] findPeakElements(int[] target) {
        // Check for edge cases
        if (target == null || target.length < 3) {
            return new int[0]; // No peaks possible
        }

        List<Integer> result = new ArrayList<>();

        // Check the first element
//        if (target[0] > target[1]) {
            result.add(target[0]);
//        }

        // Check the middle elements
        for (int i = 1; i < target.length - 1; i++) {
            if (target[i] > target[i - 1] && target[i] > target[i + 1]) {
                result.add(target[i]);
            }
        }

        // Check the last element
//        if (target[target.length - 1] > target[target.length - 2]) {
        if (target.length>2){
            result.add(target[target.length - 1]);
        }
//        }

        // Convert list to array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {

        int[] target = {1,3,3,6};
        System.out.println(Arrays.toString(target));
        System.out.println(Arrays.toString(findPeakElements(target)));
        target = new int[]{4, 3, 2, 8, 6, 3, 7};
        System.out.println(Arrays.toString(target));
        System.out.println(Arrays.toString(findPeakElements(target)));
        target = new int[]{1};
        System.out.println(Arrays.toString(target));
        System.out.println(Arrays.toString(findPeakElements(target)));
        target = new int[]{-111};
        System.out.println(Arrays.toString(target));
        System.out.println(Arrays.toString(findPeakElements(target)));

    }


}
