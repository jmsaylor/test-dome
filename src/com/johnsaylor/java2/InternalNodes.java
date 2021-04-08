package com.johnsaylor.java2;

public class InternalNodes {
    public static int count(int[] tree) {
        if (tree.length == 0 || tree.length == 1) return 0;
        int temp = 1;
        int result = 1;
        while (temp < tree.length) {
            result = temp;
            temp += (temp * 2);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(InternalNodes.count(new int[] { 1, 3, 1, -1, 3 }));
    }
}
