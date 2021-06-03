package leetcode.easy;

public class Q461 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(3, 1));
    }
    public static int hammingDistance(int a, int b) {
        return Integer.bitCount(a^b);
    }
}
