package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SieveOfEratosthenesOptimized {
    public static void main(String[] args) {
        int n = 7;
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(n);
    }

    void sieveOfEratosthenes(int limit) {
        boolean[] output = new boolean[limit + 1];

        Arrays.fill(output, true);
        output[0] = false;
        output[1] = false;

        for (int i = 2; i <= Math.pow(limit, 0.5); i++) {
            if (output[i]) {
                for (int j = (int) Math.pow(i, 2); j <= limit; j = j + i) {
                    output[j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < output.length; i++) {
            if (output[i]) {
                result.add(i);
            }
        }

        System.out.println(Arrays.toString(result.toArray()));
    }

}