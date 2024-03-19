package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Distinct {
    public static void main(String[] args) {
        System.out.println("Distinct!");
        int[] A = {2,1,1,2,3,1};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        for (int num: A){
            set.add(num);
        }

        int setAsize = Arrays.stream(A)
                .collect(HashSet::new, Set::add, Set::addAll).size();
        System.out.println("setAsize: " + setAsize);

        return set.size();


    }
}
