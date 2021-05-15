package com.johnsaylor.chdq;

import java.util.List;

public class CheckDefects {
    public static int largestArea(List<List<Integer>> samples) {
        // Write your code here
        int testArea = 1;

        for (int i = 0; i < samples.size(); i++) {
            for (int j = 0; j < samples.get(i).size(); j++) {
                while (checkDefect(testArea, i, j, samples)) {
                    testArea++;
                }
            }
        }

        return testArea - 1;

    }

    public static boolean checkDefect(int size, int x, int y, List<List<Integer>> samples) {
        if (x + size >= samples.size() || y + size >= samples.get(y).size()) {
            return false;
        }

        for (int i = x; i < x + size; i++) {
            List<Integer> row = samples.get(i);
            for (int j = y; j < y + size; j++) {
                if (row.get(j) == 0) return false;
            }
        }

        return true;
    }
}
