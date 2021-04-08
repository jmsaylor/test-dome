package com.johnsaylor.sql;

public class QuadraticEquation {

    public static void test() {
        Roots result = findRoots(2, 10, 8);
        System.out.println(result.x1 + " " + result.x2);
    }

    public static Roots findRoots(double a, double b, double c) {

        double num1 = (-1 * b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c));
        double num2 = (-1 * b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c));

        double result1 = num1 / (2 * a);
        double result2 = num2 / (2 * a);

        return new Roots(result1, result2);
    }

    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
