package org.example;

import java.util.Arrays;

class SmallestPositiveInteger {
    public static void main(String[] args) {
        System.out.println("Solution!");
        int[] A = {1,3,6,4,1,2};
        System.out.println(solution(A));
        System.out.println(solutionStreams(A));
        int[] B = {1,3,4};
        System.out.println(solution(B));
        System.out.println(solutionStreams(B));
        int[] C = {-1,-2,-3};
        System.out.println(solution(C));
        System.out.println(solutionStreams(C));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);   //1,3,4
        int smallest = 1;

        for (int num:A){
            if(num == smallest){
                smallest++;
            }else if (num > smallest){
                return smallest;
            }
        }
        return smallest;
    }
    public static int solutionStreams(int[] A) {
        // Implement your solution here
        return Arrays.stream(A)
                .sorted()
                .distinct()
                .filter(value -> value>0)
                .reduce(1, (acc, value) -> value==acc ? acc+1 : acc);
    }
}
