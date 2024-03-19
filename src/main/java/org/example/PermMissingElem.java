package org.example;

import java.util.HashSet;
import java.util.Set;

public class PermMissingElem {

    public static void main(String[] args) {
        int[] A={2, 3, 1, 5};
        System.out.println("min = " + new PermMissingElem().solution(A));
    }

    public int solution(int[] A){
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i < A.length+1; i++) {
            set.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            set.remove(A[i]);
        }

        return set.iterator().next();
    }
}