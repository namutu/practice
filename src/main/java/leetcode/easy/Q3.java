package leetcode.easy;

public class Q3 {
    public static void main(String[] args) {
//        int[] arr = {10, 2, 5, 3};
        int[] arr = {3,1,7,11};

        boolean result = solution(arr);

    }
    public static boolean solution(int[] arr) {
        for(int i=0 ; i<arr.length ; i++) {
            int num = arr[i]/2;
            if(arr[i]%2 == 0) {
                for(int j=0 ; j<arr.length ; j++) {
                    if(i==j) continue;
                    if(arr[j] == num) return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
