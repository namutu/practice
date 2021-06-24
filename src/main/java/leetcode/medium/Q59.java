package leetcode.medium;

enum direction {
    right, down, left, up
}
public class Q59 {
    public static void main(String[] args) {
        int n = 4;
        int[][] result = generateMatrix(n);
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        int[][] direc = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int d = 0;
        int row = 0;
        int col = 0;
        while(cnt <= n*n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + direc[d][0], n);
            int c = Math.floorMod(row + direc[d][1], n);

            if(result[r][c] != 0) d = (d+1) % 4;

            row += direc[d][0];
            col += direc[d][1];
        }

        return result;
    }
    private static int count = 1;
    public static void makeNumbers(direction direc, int[][] result, boolean[][] visited, int n, int col, int row) {
        System.out.println("direction : " + direc.ordinal());
        if(count > n*n) return;
        if(col < 0) {col++; direc = selectDirection(direc, visited, n, col, row);}
        if(row < 0) {row++; direc = selectDirection(direc, visited, n, col, row);}
        if(col > n-1) {col--; direc = selectDirection(direc, visited, n, col, row);}
        if(row > n-1) {row--; direc = selectDirection(direc, visited, n, col, row);}
        visited[col][row] = true;
        result[col][row] = count++;
        if(direc.ordinal() == 0) {
            System.out.println("right ");
            row++;
            makeNumbers(direc, result, visited, n, col, row);
        } else if(direc.ordinal() == 1) {
            System.out.println("down ");
            col++;
            makeNumbers(direc, result, visited, n, col, row);
        } else if(direc.ordinal() == 2) {
            System.out.println("left ");
            row--;
            makeNumbers(direc, result, visited, n, col, row);
        } else if(direc.ordinal() == 3) {
            System.out.println("up ");
            col--;
            makeNumbers(direc, result, visited, n, col, row);
        }
    }

    private static direction selectDirection(direction direc, boolean[][] visited, int n, int col, int row) {
        System.out.println("col : " + col + ", row : " + row + ", count : " + count + ", direction : " + direc.ordinal());
        if(direc.ordinal() == 0) return direction.down;
        if(direc.ordinal() == 1) return direction.left;
        if(direc.ordinal() == 2) return direction.up;
        if(direc.ordinal() == 3) return direction.right;
//        if(row+1 < n && visited[col][row+1] == true) return direction.right;
//        if(col+1 < n && visited[col+1][row] == true) return direction.down;
//        if(row-1 >= 0 && visited[col][row-1] == true) return direction.left;
//        if(col-1 >= 0 && visited[col-1][row] == true) return direction.up;
        return direction.right;
    }

    public static void setNumbers(int[][] result, boolean[][] visited, int n, int col, int row) {
        if(count > n*n) {
            return;
        }
        visited[col][row] = true;
        result[col][row] = count;
        count++;
        if (row < n-1 && visited[col][row + 1] == false) {
            setNumbers(result, visited, n, col, row + 1);
        }
        if (col < n-1 && visited[col + 1][row] == false) {
            setNumbers(result, visited, n, col + 1, row);
        }
        if (row > 0 && visited[col][row - 1] == false) {
            setNumbers(result, visited, n, col, row - 1);
        }
        if (col > 0 && visited[col - 1][row] == false) {
            setNumbers(result, visited, n, col - 1, row);
        }
    }
}






























