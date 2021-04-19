package com.johnsaylor.javainterview;
import java.util.*;

public class MovingTotal {
    List<Integer> internalList = new ArrayList<>();
    List<Integer> results = new ArrayList<>();
    int insertIndex = 0;
    int[] lastThree = new int[3];
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void append(int[] list) {
        for (int n : list) {
            internalList.add(n);
            lastThree[insertIndex % 3] = n;
            if (insertIndex >= 3) {
                System.out.println(Arrays.toString(lastThree));
                results.add((lastThree[0] + lastThree[1] + lastThree[2]));
            }
            insertIndex++;
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        return results.indexOf(total) != -1;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3, 4 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        movingTotal.append(new int[] { 5 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));
    }
}