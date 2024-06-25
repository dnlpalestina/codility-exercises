package org.example;

import java.util.Arrays;

public class BalancedJobsAssignment {

    public static int[] balancedAssignment(int n, int m, int k) {
        // Base case
        if (n == 0 || m == 0) {
            return new int[0];
        }

        // Calculate average jobs per processor (rounded down)
        int avgJobsPerProcessor = m / n;

        // Create initial assignment
        int[] assignment = new int[n];
        Arrays.fill(assignment, avgJobsPerProcessor);

        // Distribute remaining jobs to most efficient processor
        int remainingJobs = m % n;
        assignment[k] += remainingJobs;

        // Balance assignment
        for (int i = 1; i < n; i++) {
            if (assignment[i] - assignment[i - 1] > 1) {
                assignment[i - 1]++;
                assignment[i]--;
            }
        }

        return assignment;
    }

    public static void main(String[] args) {
        int numProcessors = 5;
        int numJobs = 22;
        int mostEfficientProcessor = 4; // Index of 5th processor

        int[] assignment = balancedAssignment(numProcessors, numJobs, mostEfficientProcessor);

        System.out.println("Balanced assignment: " + Arrays.toString(assignment));
    }
}
