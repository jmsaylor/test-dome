package com.johnsaylor.java2pair;

import java.util.*;

public class Veterinarian {

    ArrayDeque<String> line = new ArrayDeque<String>();

    public void accept(String name) {
        line.addLast(name);
    }

    public String heal() {
        return "a";

    }
}
