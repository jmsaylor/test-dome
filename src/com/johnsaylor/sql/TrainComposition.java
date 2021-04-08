package com.johnsaylor.sql;

import java.util.*;

public class TrainComposition {

    private ArrayDeque<Integer> trains = new ArrayDeque<Integer>();
    
    public void attachWagonFromLeft(int wagonId) {
        trains.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        trains.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        return trains.pollFirst();
    }

    public int detachWagonFromRight() {
        return trains.pollLast();
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);

        System.out.print(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
