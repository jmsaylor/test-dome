package com.johnsaylor.java2pair;

import java.util.HashSet;

public class InternalNodes {
    public static int count(int[] tree) {
        HashSet<Integer> set = new HashSet<>();

        for (int parent : tree) {
            if (parent != -1) {
                set.add(parent);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(InternalNodes.count(new int[]{-1}));
    }
}
