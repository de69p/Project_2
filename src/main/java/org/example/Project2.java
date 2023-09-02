package org.example;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        double totalGPA = 0.0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;
            // Reading each line from students.txt file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int creditHours = Integer.parseInt(parts[1]);
                int qualityPoints = Integer.parseInt(parts[2]);
                String extraInfo = parts[3];

                // Data validation for creditHours and qualityPoints
                if (creditHours <= 0 || qualityPoints <= 0) {
                    System.out.println("Invalid data for student: " + name);
                    continue;
                }

                Student student;
                // Determine if the student is an Undergraduate or a Graduate
                if (extraInfo.equals("Junior") || extraInfo.equals("Senior") || extraInfo.equals("Sophomore") || extraInfo.equals("Freshman")) {
                    student = new Undergraduate(name, creditHours, qualityPoints, extraInfo);
                } else {
                    student = new Graduate(name, creditHours, qualityPoints, extraInfo);
                }
                students.add(student);
                totalGPA += student.gpa();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File does not exist. Terminating the program.");
            return;
        }

        // Calculating the average GPA and setting the threshold for honor society
        double averageGPA = totalGPA / students.size();
        Student.setGpaThreshold((averageGPA + 4.0) / 2);
        System.out.println("Threshold for honor society membership: " + Student.getGpaThreshold());

        // Listing all students who are eligible for honor society membership
        System.out.println("Students eligible for honor society membership:");
        for (Student student : students) {
            if (student.eligibleForHonorSociety()) {
                System.out.println(student);
            }
        }
    }
}
