package com.johnsaylor.cdhqjava3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlotMachine {

    public static void main(String[] args) {
        List<String> spins = new ArrayList<>();
        spins.add("137");
        spins.add("364");
        spins.add("115");
        spins.add("724");

        System.out.println(slotWheels(spins));
    }

    public static int slotWheels(List<String> history) {
        // Write your code here
        int spins = history.get(0).length();
        int total = 0;


        // Outer loop iterates until Strings are 0 length
        for (int i = 0; i < spins; i++) {
            System.out.println(Arrays.toString(history.toArray()));
            int spinMax = 0;

            for (int wheelNumber = 0; wheelNumber < history.size(); wheelNumber++) {
                String wheel = history.get(wheelNumber);

                int localMax = 0;
                int localMaxIndex = 0;
                //Inner loop

                for (int j = 0; j < wheel.length(); j++) {
                    //grab local max and index
                    int temp = Integer.parseInt(String.valueOf(wheel.charAt(j)));
                    if (temp > localMax) {
                        localMax = temp;
                        localMaxIndex = j;
                    }
                }

                //set new String w/o max
                String left = localMaxIndex == 0 ? "" : wheel.substring(0, localMaxIndex);
                String right = localMaxIndex == wheel.length() - 1 ? "" : wheel.substring(localMaxIndex + 1);

                history.set(wheelNumber, left + right);

                spinMax = Math.max(localMax, spinMax);
            }
            total += spinMax;

        }

        return total;

    }
}
