package org.example;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        int[] A = {3,4,5,6,9,8};
        int K = 3;
        System.out.println("A = " + Arrays.toString(A));
        System.out.println("K = " + K);
        System.out.println("A = " + Arrays.toString(new CyclicRotation().solution(A, K)));
    }

    public int[] solution(int[] A, int K){
        if (A.length == 0 || K % A.length == 0) {
            return A; // No need to perform any shifts
        }

        int rotations = K % A.length; // Reduce unnecessary rotations
        System.out.println("rotations = " + rotations);

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            System.out.println("i = " + i);
            System.out.println("rotations = " + rotations);
            System.out.println("A.length = " + A.length);
            int newPosition = (i + rotations) % A.length;
            System.out.println("newPosition = " + newPosition);
            result[newPosition] = A[i];
        }

        return result;
    }
}