package leetcode.medium;

import java.util.Arrays;

public class Q48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

//        for(int i=0 ; i<matrix.length ; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
//        System.out.println();
//        rotate1(matrix);
//        for(int i=0 ; i<matrix.length ; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
        for(int i=0 ; i<matrix.length ; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        rotate2(matrix);
        System.out.println();
        for(int i=0 ; i<matrix.length ; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        for(int i=0 ; i<(n+1)/2 ; i++) {
            for(int j=0 ; j<n/2 ; j++) {
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-j-1];
                matrix[n-1-i][n-j-1] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;;
            }
        }
    }

    public static void rotate2(int[][] matrix) {
        for(int i=0 ; i<matrix.length ; i++) {
            for(int j=0 ; j<i ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println();
        for(int i=0 ; i<matrix.length ; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        for(int i=0 ; i<matrix.length ; i++) {
            for(int j=0 ; j<matrix[i].length/2 ; j++) {
                int temp = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}





















