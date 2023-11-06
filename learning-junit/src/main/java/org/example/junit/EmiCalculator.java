package org.example.junit;

public class EmiCalculator {
    public double calculateEmi(double p,double r,int n){
        double rn=r/12/100;
        return Math.round(p * rn * (Math.pow(1 + rn, n) / (Math.pow(1 + rn, n) - 1)));
    }
}
