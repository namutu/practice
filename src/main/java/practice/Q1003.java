package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Q1003 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int loop = Integer.parseInt(br.readLine());
            int[][] answer = new int[loop][2];
            for(int i=0 ; i<loop ; i++) {
                int line = Integer.parseInt(br.readLine());

                Q1003 q = new Q1003();
                q.makeTree(answer, i, line);
                System.out.println(answer[i][0] + " " + answer[i][1]);

            }

//            StringBuffer sb = new StringBuffer();
//            for(int i=0 ; i<loop ; i++) {
//                int[] temp = answer[i];
//                for(int j=0 ; j<temp.length ; j++) {
//                    sb.append(temp[j] + " ");
//                }
//                sb.append("\n");
//            }
//            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Node {
        int root;
        int left;
        int right;
    }
    public void makeTree(int[][] answer, int i, int n) {
        Node node = new Node();
        if(n == 0) {
            answer[i][0] += 1;
            return;
        } else if(n == 1) {
            answer[i][1] += 1;
            return;
        } else {
            node.root = n;
            node.left = n-1;
            node.right = n-2;
        }
        makeTree(answer, i, node.left);
        makeTree(answer, i, node.right);
    }
}











