package com.johnsaylor.java3;

// Tell which side is longer from a given chain link

enum Side {NONE, LEFT, RIGHT}

public class ChainLink {
    private ChainLink left, right;

    public void append(ChainLink rightPart){
        if (this.right != null)
            throw new IllegalStateException("Link is already connected");
        this.right = rightPart;
        this.left = this;
    }

    public Side longerSide() {
        throw new UnsupportedOperationException("To be Implemented");
    }

    public static void main(String[] args){
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);
        System.out.println(left.longerSide());
    }
}
