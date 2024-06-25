package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SieveOfEratosthenes {
    void sieveOfEratosthenes(int limit) {
        boolean[] output = new boolean[limit + 1];
        for (int x = 0; x <= limit; x++) {
            output[x] = true;
        }
        output[0] = false;
        output[1] = false;
        for (int i = 2; i <= limit; i++) {
            if (output[i] == true) {
                for (int j = i * 2; j <= limit; j = j + i) {
                    output[j] = false;
                }
            }
        }
        findTrueIndices(output);
    }

    public void findTrueIndices(boolean[] arr) {
        // create `result` ArrayList
        List<Integer> result = new ArrayList<>();

        // use for-loop to add index of `arr` elements to `result` that are `true` by calling `add()` method
        for(int i=0; i<=arr.length-1; i++){
            if(arr[i]){
                result.add(i);
            }
        }
        // Print `result`
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void main(String[] args) {
        int n = 433;
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(n);
        // should return [2, 3, 5, 7]
    }
}