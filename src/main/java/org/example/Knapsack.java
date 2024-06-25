package org.example;


public class Knapsack {

    public static int knapSack(int weightCap, int weights[], int values[], int i) {
        int index, weight;
        int matrix[][] = new int[i + 1][weightCap + 1];

        for (index = 0; index <= i; index++) {
            for (weight = 0; weight <= weightCap; weight++) {
                if (index == 0 || weight == 0)
                    matrix[index][weight] = 0;
                else if (weights[index - 1] <= weight){
                    matrix[index][weight] = Math.max(
                            values[index - 1] + matrix[index - 1][weight - weights[index - 1]],
                            matrix[index - 1][weight]);
                    System.out.println("matrix"+index+"]["+weight+"] = " + matrix[index][weight]);
                } else {
                    matrix[index][weight] = matrix[index - 1][weight];
                    System.out.println("matrix"+index+"]["+weight+"] = " + matrix[index][weight]);
                }
            }
        }
        return matrix[i][weightCap];
    }
    public static int knapSackRecursive (int weightCap, int weights[], int values[], int i) {
        if (i == 0 || weightCap == 0) {
            return 0;
        }

        else if (weights[i - 1] > weightCap) {
            return knapSackRecursive(weightCap, weights, values, i - 1);

        } else {
            return Math.max(
                    values[i - 1] + knapSackRecursive(weightCap - weights[i - 1], weights, values, i - 1),
            knapSackRecursive(weightCap, weights, values, i - 1));
        }
    }

    public static void main(String[] args) {
        int values[] = new int[] { 60, 50, 70, 30 };
        int weights[] = new int[] { 5, 3, 2, 1 };
        int weightCap = 5;
        int i = values.length;
        System.out.println(knapSackRecursive(weightCap, weights, values, i));
    }
}