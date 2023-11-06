package org.example.junit;

import java.util.ArrayList;
import java.util.List;

public class MathOperations {
    public int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    public int[] generatePrime(int lb, int ub) {
        if (lb < 0 || ub < 0) {
            throw new IllegalArgumentException("lb and ub must be a positive number.");
        }
        if (lb > ub) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();

        for (int i = lb; i <= ub; i++) {
            if (isPrime(i))
                list.add(i);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int div(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Denominator should not be zero");
        return a / b;
    }
}
