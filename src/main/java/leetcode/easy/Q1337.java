package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q1337 {
    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0},{1,1,1,1,1}};
        int k = 3;

        int[] result = kWeakestRows(mat, k);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
    static class Pair {
        int row;
        int power;
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        List<Pair> list = new ArrayList<>();
        int power = 0;
        for(int i=0 ; i<mat.length ; i++) {
            for(int j=0 ; j<mat[i].length ; j++) {
                if(mat[i][j] == 1) power+=1;
                else continue;
            }
            Pair p = new Pair();
            p.row = i;
            p.power = power;
            list.add(p);
            power = 0;
        }
        for(Pair p : list) {
            System.out.println("row : " + p.row + ", power : " + p.power);
        }
        System.out.println();
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.power - o2.power;
            }
        });
        for(Pair p : list) {
            System.out.println("row : " + p.row + ", power : " + p.power);
        }
        int[] result = new int[k];
        for(int i=0 ; i<result.length ; i++) {
            result[i] = list.get(i).row;
        }

        return result;
    }
}




