package leetcode.medium;

public class Q59 {
    public static void main(String[] args) {
        int n = 3;
        int[][] result = generateMatrix(n);
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        boolean[][] visited = new boolean[n][n];
        int[][] result = new int[n][n];

        int col = 0;
        int row = 0;
        int count = n*n;
        int num = 0;
        setNumbers(result, visited, n, 0, 0);

        return result;
    }
    private static int count;
    public static void setNumbers(int[][] result, boolean[][] visited, int n, int col, int row) {
        if(count == n*n) {
            return;
        }
        visited[col][row] = true;
        result[col][row] = count+1;
        count++;
        System.out.println("col : " + col + ", row : " + row + ", count : " + count);
        if (col < n-1 && visited[col + 1][row] == false) {
            System.out.println("1111");
            setNumbers(result, visited, n, col + 1, row);
        }
        if (row > 0 && visited[col][row - 1] == false) {
            System.out.println("4444");
            setNumbers(result, visited, n, col, row - 1);
        }
        if (col > 0 && visited[col - 1][row] == false) {
            System.out.println("2222");
            setNumbers(result, visited, n, col - 1, row);
        }
        if (row < n-1 && visited[col][row + 1] == false) {
            System.out.println("3333");
            setNumbers(result, visited, n, col, row + 1);
        }
    }
}






























