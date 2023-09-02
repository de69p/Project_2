package org.example;

public class Student {
    private final String name;
    private final int creditHours;
    private final int qualityPoints;
    private static double gpaThreshold;
    
    public Student(String name, int creditHours, int qualityPoints) {
        this.name = name;
        this.creditHours = creditHours;
        this.qualityPoints = qualityPoints;
    }
    
    public double gpa() {
        return (double) qualityPoints / creditHours;
    }
    
    public boolean eligibleForHonorSociety() {
        return gpa() > gpaThreshold;
    }
    
    @Override
    public String toString() {
        return name + ", GPA: " + gpa();
    }
    
    public static void setGpaThreshold(double threshold) {
        gpaThreshold = threshold;
    }
    
    public static double getGpaThreshold() {
        return gpaThreshold;
    }
}
