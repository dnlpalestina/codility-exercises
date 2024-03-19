package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int[] A = {9,3,9,3,9,9,9};
        System.out.println("A = " + new OddOccurrencesInArray().solution(A));
        int[] B = {9,3,9,3,9,9,9};
        System.out.println("A = " + new OddOccurrencesInArray().solutionArrayList(B));
    }

    public int solution(int[] A){
        if (A.length % 2 == 0) {
            return 0; // No need to perform any iterations
        }

        Arrays.sort(A);
        System.out.println("A = " + Arrays.toString(A));
        for (int i = 0; i < A.length-1; i+=2) {

            System.out.println("A[i]+A[i+1] = " + A[i] + A[i + 1]);

            if(A[i]!=A[i+1]){
                return A[i];
            }
        }
        return A[A.length-1];
    }
    public int solutionArrayList(int[] A){
        if (A.length % 2 == 0) {
            return 0; // No need to perform any iterations
        }
        HashSet<Integer> arrayList = new HashSet<>();
        System.out.println("A = " + Arrays.toString(A));
        for (int i = 0; i < A.length; i++) {
            if (arrayList.contains(A[i])){
                arrayList.remove(A[i]);
            }else {
                arrayList.add(A[i]);
            }
        }
        return arrayList.iterator().next();
    }
}