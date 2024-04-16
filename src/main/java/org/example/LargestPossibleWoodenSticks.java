package org.example;

import java.util.Arrays;

import static java.lang.Math.max;

public class LargestPossibleWoodenSticks {

    public static void main(String[] args) {

        System.out.println("LargestPossibleWoodenSticks");
        // There are two wooden sticks of lengths A and B respectively.
        // Each of them can be cut into shorter sticks of integer lengths.
        // Our goal is to construct the largest possible square.
        System.out.println(new LargestPossibleWoodenSticks().solution(10,21));
        System.out.println(new LargestPossibleWoodenSticks().solution(13,11));
        System.out.println(new LargestPossibleWoodenSticks().solution(2,1));
        System.out.println(new LargestPossibleWoodenSticks().solution(1,8));
    }

    public int oldSolution(int A, int B) {
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        int totalSticks = A+B;
        int maxSideLength = totalSticks/4;
        for (int sideLength = maxSideLength; sideLength >= 1; sideLength--) {
            int sticksFromA = A / sideLength;
            int sticksFromB = B / sideLength;
            if(sticksFromA+sticksFromB >=4){
                return sideLength;
            }
        }
        return 0;
    }

    public int solution(int A, int B) {
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        int maxSize = 0;

        maxSize = max(maxSize, B/4);
        if (A >= (B/3))
            maxSize = max(maxSize, B/3);
        if (A >= 2*(B/2))
            maxSize = max(maxSize, B/2);
        if (B >= (A/3))
            maxSize = max(maxSize, A/3);
        maxSize = max(maxSize, A/4);

        return maxSize;
    }

}