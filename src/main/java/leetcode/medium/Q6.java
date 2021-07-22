package leetcode.medium;

public class Q6 {
    public static void main(String[] args) {
//        String s = "PAYPALISHIRING";
//        int numRows = 2;

        String s = "ABCD";
        int numRows = 2;

        String answer = conversion(s, numRows);
        System.out.println("answer : " + answer);
    }
    public static String conversion(String s, int numRows) {
        if(numRows == 1) return s;
//        int numCols = s.length()/(numRows-3);
        int numCols = s.length();
        char[][] answerArray = new char[numRows][numCols];

        char[] chars = s.toCharArray();
        int idx = 0, row = 0, col = 0;
        boolean downDirection = true;
        while(idx < chars.length) {
            System.out.println("idx : " + idx + ", char["+idx+"] : " + chars[idx] + ", row : " + row + ", col : " + col + ", direction : " + downDirection);
            if(downDirection) {
                answerArray[row][col] = chars[idx];
                if(row == numRows-1) {
                    downDirection = false;
                    col++;
                    row--;
                } else {
                    row++;
                }
            } else {
                answerArray[row][col] = chars[idx];
                if(row > 0) {
                    row--;
                    col++;
                } else {
                    row++;
                }
                if(row == 0) downDirection = true;
            }
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<answerArray.length ; i++) {
            for(int j=0 ; j<answerArray[i].length ; j++) {
                System.out.print(answerArray[i][j] + " ");
                if(answerArray[i][j] != Character.MIN_VALUE) sb.append(answerArray[i][j]);
            }
            System.out.println();
        }
        return sb.toString();
    }
}
