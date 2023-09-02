package org.example;

public class Undergraduate extends Student {
    private final String year;
    
    public Undergraduate(String name, int creditHours, int qualityPoints, String year) {
        super(name, creditHours, qualityPoints);
        this.year = year;
    }
    
    @Override
    public boolean eligibleForHonorSociety() {
        return (year.equals("Junior") || year.equals("Senior")) && super.eligibleForHonorSociety();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Year: " + year;
    }
}
