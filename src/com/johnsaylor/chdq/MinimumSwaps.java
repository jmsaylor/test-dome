package com.johnsaylor.chdq;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumSwaps {

    public static void main(String[] args){
        System.out.println(minimumSwaps("))()(()("));
    }

    public static int minimumSwaps(String brackets) {
        // Write your code here
        System.out.println(brackets);
        Deque<Character> queue = new ArrayDeque<>();

        for (char bracket : brackets.toCharArray()) {
            if (queue.isEmpty() || bracket == '(') {
                queue.add(bracket);
                continue;
            }

            char previousBracket = queue.pollLast();

            if (previousBracket == '(' && bracket == ')') {
                continue;
            } else {
                queue.addLast(previousBracket);
                queue.addLast(bracket);
            }

        }

        System.out.println(queue);
        int[] balanced = new int[]{0, 0};

        while (!queue.isEmpty()) {
            if (queue.poll() == '(') {
                balanced[0]++;
            } else {
                balanced[1]++;
            }
        }

        return balanced[0] == balanced[1] ? balanced[0] : -1;
    }
}
