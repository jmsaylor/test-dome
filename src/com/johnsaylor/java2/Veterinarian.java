package com.johnsaylor.java2;

import java.util.ArrayDeque;

public class Veterinarian {
    private ArrayDeque<String> deque;

    public Veterinarian(){
        this.deque = new ArrayDeque<>();
    }

    public void accept(String petName) {
        deque.addLast(petName);
    }

    public String heal() {
        return deque.pollFirst();
    }

    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.accept("Barkley");
        veterinarian.accept("Mittens");
        System.out.println(veterinarian.heal());
        System.out.println(veterinarian.heal());
    }
}
