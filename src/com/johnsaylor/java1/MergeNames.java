package com.johnsaylor.java1;
import java.util.HashSet;


public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        HashSet<String> set = new HashSet<>();
        int length = Math.max(names1.length, names2.length);
        for (int i = 0; i < length; i++){
            if (i < names1.length) set.add(names1[i]);
            if (i < names2.length) set.add(names2[i]);
        }

        String[] result = new String[set.size()];
        int index = 0;

        for (Object o : set.toArray()){
            result[index++] = (String) o;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
