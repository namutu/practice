package leetcode.easy;

public class Q867 {
    public static void main(String[] args) {
//        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] nums = {{1,2,3},{4,5,6}};
        for(int i=0 ; i<nums.length ; i++) {
            for(int j=0 ; j<nums[i].length ; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        int[][] result = transpose(nums);

        for(int i=0 ; i<result.length ; i++) {
            for(int j=0 ; j<result[i].length ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int column = matrix.length;
        int row = matrix[0].length;

        int[][] newMatrix = new int[row][column];

        for(int i=0 ; i<column; i++) {
            for(int j=0 ; j<row; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}

















