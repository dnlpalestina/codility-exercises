package org.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.max;

public class getTheBestAvgs {

    public static void main(String[] args) {

        System.out.println("getTheBestAvgs");
        
        //This students object holds the name and a list of subject qualification values
        Map<String, Collection<Integer>> students = new HashMap<>();
        students.put("A", new ArrayList<>(Arrays.asList(20,30,40)));
        students.put("B", new ArrayList<>(Arrays.asList(20,30,25)));
        students.put("C", new ArrayList<>(Arrays.asList(10,10,100)));
        students.put("D", new ArrayList<>(Arrays.asList(80,30,50)));
        students.put("D", new ArrayList<>(Arrays.asList(100,100,100)));

        //This method should return a list of 'n' names with the best average of subject qualification values
        System.out.println(new getTheBestAvgs().solution(students,3));
    }

    public List<String> solution(Map<String, Collection<Integer>> students, int numBestAvgs) {

        IntStream.range(0,numBestAvgs).forEach(System.out::println);

        // Create a stream from the students map
        List<String> result = students.entrySet().stream()
                // Calculate average for each student's list of qualification values
                .map(entry -> {
                    String name = entry.getKey();
                    Collection<Integer> qualifications = entry.getValue();
                    Double average = qualifications.stream()
                            .mapToDouble(Integer::doubleValue)
                            .average()
                            .orElse(0.0); // Default to 0 if no qualifications
                    System.out.println("name = " + name);
                    System.out.println("average = " + average);
                    return new AbstractMap.SimpleEntry<>(name, average);
                })
                // Sort the entries based on the average
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                // Extract only the student names from the sorted entries
                .limit(numBestAvgs)
                .map(stringDoubleSimpleEntry -> {
                    String name = stringDoubleSimpleEntry.getKey();
                    double average = stringDoubleSimpleEntry.getValue();
                    System.out.println("nameLimited = " + name);
                    System.out.println("averageLimited = " + average);
                    return new AbstractMap.SimpleEntry<>(name, average) {};
                })
                .map(Map.Entry::getKey)
                // Collect the names into a list
                .toList(); // Requires Java 16 or higher, otherwise use .collect(Collectors.toList());

        return result;
    }

}