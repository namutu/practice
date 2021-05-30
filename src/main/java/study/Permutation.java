package study;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] output = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        perm(arr, output, visited, 0, arr.length, 3);
    }
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            print(output, r);
            System.out.println();
            return;
        }

        for(int i=0; i<n ; i++) {
            if(visited[i] == false) {
                System.out.println("i : " + (i) + ", depth : " + (depth) + ", v : " + arr[i]);
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
    static void print(int[] output, int r) {
        for(int i=0 ; i<r ; i++) {
            System.out.print(output[i]);
        }
    }
}








