package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HighestGrade {

    public static void main(String[] args) {

        System.out.println("Get The HighestGrade");

        List<Student> students = Arrays.asList(
                new Student("Amine", "Ousmane", "Computer Science", Map.of("Algorithms", 90, "Data Structures", 80, "Calculus", 85)),
                new Student("Lily-Ann", "Smith", "Mathematics", Map.of("Algorithms", 80, "Data Structures", 75, "Calculus", 88)),
                new Student("Li", "Wei", "Computer Science", Map.of("Algorithms", 92, "Data Structures", 89, "Calculus", 88)),
                new Student("Jessica", "Rodriguez", "Mathematics", Map.of("Algorithms", 85, "Data Structures", 80, "Calculus", 89)));
        String major = "Computer Science";
        System.out.println(HighestGrade.findAnswer(students, major));
    }

    // Return the highest grade for the students with a specific major
    static int findAnswer(List<Student> students, String major) {
        return students.stream()
                .filter(s -> major.equals(s.getMajor()))
                .flatMap(s -> s.getGrades().values().stream())
                .max(Integer::compareTo).orElseGet(()->0);
    }

    static class Student {
        private String firstname;
        private String lastname;
        private String major;
        private Map<String, Integer> grades;

        public Student(String firstname, String lastname, String major, Map<String, Integer> grades) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.major = major;
            this.grades = grades;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public String getMajor() {
            return major;
        }

        public Map<String, Integer> getGrades() {
            return grades;
        }
    }
}