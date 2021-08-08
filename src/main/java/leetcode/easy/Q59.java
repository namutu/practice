package leetcode.easy;

import java.util.Arrays;

public class Q59 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        int n = 4;
        int[][] answer = generateMatrix(n);
        for (int i=0 ; i<answer.length ; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        if(n == 1) {
            answer[0][0] = 1;
            return answer;
        }
        int[][] nums = new int[n][n];
        int count = 1;
        for(int i=0 ; i<nums.length ; i++) {
            for(int j=0 ; j<nums[i].length ; j++) {
                nums[i][j] = count;
                count++;
            }
        }

        boolean[][] visited = new boolean[n][n];
        int maxNum = n*n;
        int num = 1;
        int x = 0;
        int y = 0;
        direction direc = direction.right;
        // right, down, left, up
        while (num <= maxNum) {
//            System.out.println("x : " + x + ", y : " + y + ", num : " + num + ", direc : " + direc);
            if(x<n && x>=0 && y>=0 && y<n && visited[x][y] == false) {
//                System.out.println("in x : " + x + ", y : " + y + ", num : " + num + ", direc : " + direc);
                answer[x][y] = num;
                num++;
                visited[x][y] = true;
                if(direc == direction.right) y++;
                if(direc == direction.down) x++;
                if(direc == direction.left) y--;
                if(direc == direction.up) x--;
            } else {
//                System.out.println("other x : " + x + ", y : " + y + ", num : " + num + ", direc : " + direc);
                if(direc == direction.right) {
//                    System.out.println("right x : " + x + ", y : " + y + ", num : " + num + ", direc : " + direc);
                    direc = direction.down;
                    y--;
                    x++;
                } else if(direc == direction.down) {
//                    System.out.println("down x : " + x + ", y : " + y + ", num : " + num + ", direc : " + direc);
                    direc = direction.left;
                    x--;
                    y--;
                } else if(direc == direction.left) {
//                    System.out.println("left x : " + x + ", y : " + y + ", num : " + num + ", direc : " + direc);
                    direc = direction.up;
                    x--;
                    y++;
                } else if(direc == direction.up) {
//                    System.out.println("up x : " + x + ", y : " + y + ", num : " + num + ", direc : " + direc);
                    direc = direction.right;
                    x++;
                    y++;
                }
            }
        }

        return answer;
    }

}
enum direction {
    right, down, left, up
}



















