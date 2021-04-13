package com.johnsaylor.java2;

public class InternalNodes {
    public static int count(int[] tree) {
        if (tree.length == 0 || tree.length == 1) return 0;
        int temp = 1;
        int result = 1;
        while (temp < tree.length) {
            result = temp;
            temp += (temp * 2);
        }

        return result;
    }

    public static int count2(int[] tree) {
        int internalNodeCount = 0;
        //find where start of first level is
        // using 0 as a null value
        int startIndex = tree[0] != 0 ? 1 : 2;
        // move by two through length of array
        for (int i = startIndex; (i + 2) < tree.length; i+=2) {
            //if either pair is not null, indicates internal node so add to count
            if (tree[i] > 0 || tree[i + 1] > 0) {
                internalNodeCount++;
            }
        }

        //return internal node count
        return internalNodeCount;
    }

    public static int count3(int[] tree) {
        //this solution assumes a complete and balanced binary tree
        int internalNodeCount = 0;
        int level = 0;

        //find how many complete levels there are
        while (tree.length > level * 2) {
            level++;
            //put number of complete levels through a formula that gives count of internal nodes, add this to count
            internalNodeCount += (level / 2);
        }
        //get the cieling of the number of nodes in the incomplete level / 2 & add to count
        int incompleteLevelNodeCount = tree.length - (level * 2);
        if (incompleteLevelNodeCount % 2 == 1) incompleteLevelNodeCount+=1;
        internalNodeCount = internalNodeCount + incompleteLevelNodeCount;
        //return count
        return internalNodeCount;
    }


    public static void main(String[] args) {
//        System.out.println(InternalNodes.count(new int[] { 1, 3, 1, -1, 3 }));
    }
}
