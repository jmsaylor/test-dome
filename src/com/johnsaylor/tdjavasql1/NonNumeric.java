package com.johnsaylor.tdjavasql1;

import com.johnsaylor.java2pair.InternalNodes;

public class NonNumeric {
    public static class TextInput {
        String currentValue = "";

        void add(char c){
            currentValue = currentValue.concat(String.valueOf(c));
        }
        String getValue(){
            return currentValue;
        }
    }

    public static class NumericInput extends TextInput {
        @Override
        void add(char c){
            if (Character.getNumericValue(c) > 9) return;
            currentValue = currentValue.concat(String.valueOf(c));
        }

    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
