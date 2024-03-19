package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class GroceryStoreSimulationWithQueue {
    public static void main(String[] args) {

        System.out.println("StacksAndQueues!");
        int[] scenario = {0, 1, 0, 0, 1, 1, 0, 1, 1,1,1,1};
        System.out.println("Minimum number of people needed: " + countMinimumPeople(scenario));
    }

    public static int countMinimumPeople(int[] A) {
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;

        for (int action : A) {
            if (action == 0) {
                queue.offer(action);
            } else {
                if (!queue.isEmpty()) {
                    queue.poll(); // Serve the person at the front of the queue
                } else {
                    result++; // Increment result if trying to serve when the queue is empty
                }
            }
        }
        return result;
    }
}
