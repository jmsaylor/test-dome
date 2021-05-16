package com.johnsaylor.cdhqjava3;

import java.util.regex.Pattern;

class ItemSeparator {
    String name;
    Double price;
    Integer quantity;

    public ItemSeparator(String rawInput) {
        Pattern pattern = Pattern.compile("(.*)[$][$][#][#](.*)[$][$][#][#](.*)");
    }
}
