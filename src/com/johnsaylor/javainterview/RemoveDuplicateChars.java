package com.johnsaylor.javainterview;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicateChars {

    public static void main(String[] args) {
        System.out.println(transform("abbcbbb"));
    }

    public static String transform(String input) {
        HashSet<Character> set = new LinkedHashSet<>();

        for (char c : input.toCharArray()) {
            set.add(c);
        }

        return new StringBuilder(set.toString()).toString();
    }


    public static String transform2(String input) {
        StringBuilder sb = new StringBuilder(input);
        int index = 0;

        char previous = ' ';
        char current = ' ';


        while (index < sb.length()) {
            current = sb.charAt(index);

            if (previous != current) {
                previous = current;
                index++;
            } else {
                int end = index;
                while (end < sb.length() && sb.charAt(end) == current) end++;
                sb.delete(index, end);
            }
        }

        return sb.toString();
    }
}
