package org.example;

public class GroceryStoreSimulation {
    public static void main(String[] args) {

        System.out.println("StacksAndQueues!");
        int[] scenario = {0, 1, 0, 0, 1, 1, 0, 1, 1};
        System.out.println("Minimum number of people needed: " + countMinimumPeople(scenario));
    }

    public static int countMinimumPeople(int[] A) {
        int n = A.length;
        int size = 0, result = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                size++;
            } else {
                size--;
                result = Math.max(result, -size);
            }
        }

        return result;
    }

}
