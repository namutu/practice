package study;

import java.util.LinkedList;
import java.util.Queue;

class Graph2 {
    Node[] nodes;
    Graph2(int size) {
        nodes = new Node[size];
        for(int i=0 ; i<size ;i++) {
            Node n = new Node(i);
            nodes[i] = n;
        }
    }
    class Node{
        int data;
        boolean marked;
        LinkedList<Node> adjacent;
        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
    void bfs() {
        bfs(0);
    }
    void bfs(int root) {
        Node r = nodes[root];
        r.marked = true;
        Queue<Node> q = new LinkedList<>();
        q.add(r);
        while (!q.isEmpty()) {
            Node n = q.poll();
            for(Node c : n.adjacent) {
                if(c.marked == false) {
                    c.marked = true;
                    q.add(c);
                }
            }
            System.out.print(n.data + " ");
        }//while
    }
}
public class BFS {
    public static void main(String[] args) {
        Graph2 g2 = new Graph2(9);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 3);
        g2.addEdge(2, 4);
        g2.addEdge(2, 3);
        g2.addEdge(3, 4);
        g2.addEdge(3, 5);
        g2.addEdge(5, 6);
        g2.addEdge(5, 7);
        g2.addEdge(6, 8);
        g2.bfs();
    }
}


















