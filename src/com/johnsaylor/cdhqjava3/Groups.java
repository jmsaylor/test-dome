package com.johnsaylor.cdhqjava3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Groups {

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> row = new ArrayList<>();
            String rowString = "0000000001";
            for (int cell : rowString.toCharArray()) {
                row.add(cell);
            }
            grid.add(row);
        }
        List<Integer> query = new ArrayList<>();

        onesGroups(grid, query);

    }


    public static List<Integer> onesGroups(List<List<Integer>> grid, List<Integer> queries) {
        // Write your code here
        boolean[][] visited = new boolean[grid.size()][];
        Arrays.fill(visited, new boolean[grid.size()]);

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                int groupSize = findGroupSize(visited, grid, i, j);
                if (count.containsKey(groupSize)) {
                    int temp = count.get(groupSize);
                    count.put(groupSize, temp + 1);
                } else {
                    count.put(groupSize, 1);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (Integer query : queries) {
            if (count.containsKey(query)) {
                result.add(count.get(query));
            } else {
                result.add(0);
            }
        }


        return result;
    }

    public static int findGroupSize(boolean[][] visited, List<List<Integer>> grid, int x, int y) {
        if (x >= grid.size() || y >= grid.size() || x < 0 || y < 0 || visited[x][y] == true) {
            return 0;
        }

        if (grid.get(x).get(y) == 0) {
            return 0;
        }

        visited[x][y] = true;

        return 1 + findGroupSize(visited, grid, x + 1, y) + findGroupSize(visited, grid, x - 1, y)
                + findGroupSize(visited, grid, x, y + 1) + findGroupSize(visited, grid, x, y - 1);

    }
}
