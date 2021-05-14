package com.johnsaylor.hackerrank2;

import java.util.Arrays;


public class ArrayBST {
    int[] bst;

    public static void main(String[] args){
        int[] nums = new int[]{7, 4, 11, 2, 20, 5, 8};
    }

    public int[] create(int[] values) {
        Arrays.sort(values);

        bst = new int[values.length];
        return null;
    }

    public void add(int value) {
        int index = 0;

//        while ()

        if (value > bst[index]) {
            setRight(value, index);
        } else {
            setLeft(value, index);
        }
    }

    public void setLeft(int value, int root) {
        int index = root * 2 + 1;
        bst[index] = value;
    }

    public void setRight(int value, int root){
        int index = root * 2 + 2;
        bst[index] = value;
    }
}


