package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BalancedJobsAssignmentRandomized {

    public static int[] balancedAssignmentUnequal(int n, int m, int k) {
        // Base case
        if (n == 0 || m == 0) {
            return new int[0];
        }

        // Calculate average jobs per processor (rounded down)
        int avgJobsPerProcessor = m / n;

        // Create initial assignment
        int[] assignment = new int[n];
        Arrays.fill(assignment, avgJobsPerProcessor);

        // Distribute remaining jobs, prioritizing most efficient processor
        int remainingJobs = m % n;
        assignment[k] += remainingJobs;

        // Randomly distribute remaining jobs among non-most-efficient processors
        List<Integer> nonEfficientProcessors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != k) {
                nonEfficientProcessors.add(i);
            }
        }
        Collections.shuffle(nonEfficientProcessors);
        for (int job = 0; job < remainingJobs; job++) {
            assignment[nonEfficientProcessors.get(job)] += 1;
        }

        // Ensure no processor has an excessive difference with its neighbors
        int maxDifference = 1; // Adjust this value to control the maximum allowed difference
        for (int i = 1; i < n; i++) {
            if (assignment[i] - assignment[i - 1] > maxDifference) {
                // Shift jobs to maintain a balanced distribution within the limit
                int shiftAmount = Math.min(assignment[i] - assignment[i - 1] - maxDifference, assignment[i]);
                assignment[i - 1] += shiftAmount;
                assignment[i] -= shiftAmount;
            }
        }

        return assignment;
    }

    public static void main(String[] args) {
        int numProcessors = 5;
        int numJobs = 13; // Increased number of jobs for unequal distribution
        int mostEfficientProcessor = 4; // Index of 5th processor

        int[] assignment = balancedAssignmentUnequal(numProcessors, numJobs, mostEfficientProcessor);

        System.out.println("Assignment: " + Arrays.toString(assignment));
    }
}
