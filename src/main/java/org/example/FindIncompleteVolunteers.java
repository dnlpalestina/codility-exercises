package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindIncompleteVolunteers {

    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
        int minimumEvents = 2; // Minimum number of events required

        Map<String, Integer> studentsEventCount = students.stream()
                .collect(Collectors.toMap(s -> s, n -> 0));
        attendeesMapping.values()
                .forEach(list -> list.stream()
                        .filter(student -> studentsEventCount.containsKey(student))
                        .forEach(filteredStudent -> studentsEventCount.put(filteredStudent,
                                studentsEventCount.get(filteredStudent)+1)));
        return studentsEventCount.entrySet().stream()
                .filter(map -> map.getValue()<2)
                .map(findStudentsWithIncompleteVolunteerEventsMap -> findStudentsWithIncompleteVolunteerEventsMap
                        .getKey())
                .toList();
    }

    public static List<String> findStudentsWithIncompleteVolunteerEventsImperativeProgramming(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
        List<String> result = new ArrayList<>();
        int minimumEvents = 2; // Minimum number of events required
        List<String> incompleteStudents = new ArrayList<>();

        for (String student : students) {
            int attendedEvents = 0;
            for (List<String> attendees : attendeesMapping.values()) {
                if (attendees.contains(student)) {
                    attendedEvents++;
                }
            }
            if (attendedEvents < minimumEvents) {
                incompleteStudents.add(student);
            }
        }

        return incompleteStudents;
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }
}