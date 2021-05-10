package com.johnsaylor.java3;

public class Platformer {

        private Tile tiles;
        private Tile currentTile;

        class Tile {
            Integer number;
            public Tile prev;
            public Tile next = null;
            Tile(Integer number, Tile prev) {
                this.number = number;
                this.prev = prev;
            }
        }

        public Platformer(int n, int position) {
            tiles = new Tile(0, null);
            Tile prev = tiles;

            for (int i = 1; i < n; i++) {
                prev.next = new Tile(i, prev);
                prev = prev.next;
                if (i == position) {
                    currentTile = prev;
                }
            }

        }

        public void jumpLeft() {
            Tile toDelete = currentTile;
            currentTile = currentTile.prev.prev;
            toDelete.next.prev = toDelete.prev == null ? null : toDelete.prev.next;
            toDelete.prev.next = toDelete.next == null ? null : toDelete.next.prev;
        }

        public void jumpRight() {
            Tile toDelete = currentTile;
            currentTile = currentTile.next.next;
            toDelete.next.prev = toDelete.prev == null ? null : toDelete.prev.next;
            toDelete.prev.next = toDelete.prev == null ? null : toDelete.next.prev;
        }

        public int position() {
            return currentTile.number;
        }

        public static void main(String[] args) {
            Platformer platformer = new Platformer(6, 3);
            System.out.println(platformer.position()); // should print 3

            platformer.jumpLeft();
            System.out.println(platformer.position()); // should print 1

            platformer.jumpRight();
            System.out.println(platformer.position()); // should print 4
        }
}

