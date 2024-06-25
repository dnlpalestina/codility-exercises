package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIndexes {
    public static void main(String[] args) {
        System.out.println("Indices_of_sum!");
        System.out.println(getIndices(Arrays.asList(7,17,13,19,55),24));
    }

    // Return the indices of the numbers in the source list that add up to target
    static List<Integer> getIndices(List<Integer> source, int target) {
    //    Map<Integer,Integer> complementMap = new HashMap<>();
    //    for (int i = 0; i < source.size(); i++) {
    //        var currentNum = source.get(i);
    //        var currentComp = target-currentNum;
    //        if (complementMap.containsKey(currentComp)){
    //            return Arrays.asList(complementMap.get(currentComp), i);
    //        }
    //        complementMap.put(currentNum, i);
    //    }

// Take the target and substract the numbers in source as you iterate through
// that gives you a number that you are looking for
// and if you find that number in the source array at a different index that the current you are on
// then that's the solution
        Map<Integer, Integer> sourceMap = new HashMap<>();
        //Fill a map with the values in source for easier search
        for (int i = 0; i < source.size(); i++) {
            sourceMap.put(source.get(i), i);
        }
        for (int i = 0; i < source.size(); i++) {
            int solutionNum = target-source.get(i); //24-7=17
            //There is a 17 && the index is different to the one im on
            if(sourceMap.containsKey(solutionNum) && sourceMap.get(solutionNum)!=i){
                return Arrays.asList(i, sourceMap.get(solutionNum));
            }
        }


//         Map<Integer, Integer> complementsMap = new HashMap<>();
//         for (int i = 0; i < source.size(); i++) {
//             var complementIndex = complementsMap.get(source.get(i));
//             if (complementIndex != null){
//                 return Arrays.asList(complementIndex, i);
//             }
//             complementsMap.put(target-source.get(i), i);
//         }

         return Arrays.asList(-1,-1);
    }
}