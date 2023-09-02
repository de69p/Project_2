package org.example;

public class Graduate extends Student {
    private final String degree;
    
    public Graduate(String name, int creditHours, int qualityPoints, String degree) {
        super(name, creditHours, qualityPoints);
        this.degree = degree;
    }
    
    @Override
    public boolean eligibleForHonorSociety() {
        return degree.equals("Masters") && super.eligibleForHonorSociety();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Degree: " + degree;
    }
}
