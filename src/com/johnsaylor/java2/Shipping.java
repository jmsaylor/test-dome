package com.johnsaylor.java2;

public class Shipping {
    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        int large = 0;
        int small = 0;

        while (items / 5 > 0 && availableLargePackages > 0) {
            items -= 5;
            large++;
            availableLargePackages--;
        }

        while (items > 0 && availableSmallPackages > 0) {
            items--;
            small++;
            availableSmallPackages--;
        }

        return items == 0 ? (large + small) : -1;
    }

    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 2, 10));
    }
}
