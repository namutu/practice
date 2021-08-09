package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> answer = spiralOrder(matrix);
        System.out.println("answer " + answer.toString());
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int colLength = matrix[0].length;
        int rowLength = matrix.length;
        System.out.println("colLength : " + colLength + ", rowLength : " + rowLength);
        int max = matrix.length * matrix[0].length;
        if(max == 0) return answer;
        if(max == 1) {
            answer.add(matrix[0][0]);
            return answer;
        }

        int index = 1;
        int x = 0;
        int y = 0;
        boolean[][] visited = new boolean[rowLength][colLength];
        direct direc = direct.right;
        while (index <= max) {
            System.out.println("x : " + x + ", y : " + y + ", index : " + index);
            if(x>=0 && x<colLength && y>=0 && y<rowLength && visited[y][x] == false) {
                answer.add(matrix[y][x]);
                index++;
                visited[y][x] = true;
                if(direc == direct.right) x++;
                if(direc == direct.down) y++;
                if(direc == direct.left) x--;
                if(direc == direct.up) y--;
            } else {
                if(direc == direct.right) {
                    direc = direct.down;
                    x--; y++;
                } else if(direc == direct.down) {
                    direc = direct.left;
                    x--; y--;
                } else if(direc == direct.left) {
                    direc = direct.up;
                    x++; y--;
                } else if(direc == direct.up) {
                    direc = direct.right;
                    x++; y++;
                }
            }
        }
        System.out.println("answer " + answer.toString());

        return answer;
    }
}
enum direct {
    right, down, left, up
}
























