package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class Q4 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String answer = solution(numbers, hand);
        System.out.println("answer : " + answer);
    }
    public static String solution(int[] numbers, String hand) {
        Map<String, int[]> keys = new HashMap<>();
        keys.put("1", new int[]{0,0});
        keys.put("2", new int[]{0,1});
        keys.put("3", new int[]{0,2});
        keys.put("4", new int[]{1,0});
        keys.put("5", new int[]{1,1});
        keys.put("6", new int[]{1,2});
        keys.put("7", new int[]{2,0});
        keys.put("8", new int[]{2,1});
        keys.put("9", new int[]{2,2});
        keys.put("*", new int[]{3,0});
        keys.put("0", new int[]{3,1});
        keys.put("#", new int[]{3,2});

        StringBuilder answerBuilder = new StringBuilder();
        String lastLeft = "*";
        String lastRight = "#";
        for(int i=0 ; i<numbers.length ; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answerBuilder.append("L");
                lastLeft = numbers[i] + "";
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answerBuilder.append("R");
                lastRight = numbers[i] + "";
            } else {
                int[] currentLocation = keys.get(numbers[i]+"");
                int[] leftLocation = keys.get(lastLeft);
                int[] rightLocation = keys.get(lastRight);

                double leftDistance = Math.ceil(Math.sqrt(Math.pow(currentLocation[0]-leftLocation[0], 2) + Math.pow(currentLocation[1]-leftLocation[1], 2)));
                double rightDistance = Math.ceil(Math.sqrt(Math.pow(currentLocation[0]-rightLocation[0], 2) + Math.pow(currentLocation[1]-rightLocation[1], 2)));
                System.out.println("lastLeft : " + lastLeft + ", lastRight : " + lastRight);
                System.out.println("leftD : " + leftDistance + ", rightD : " + rightDistance);
                if(leftDistance == rightDistance) {
                    if(hand.equals("right")) {
                        answerBuilder.append("R");
                        lastRight = numbers[i] + "";
                    }
                    else {
                        answerBuilder.append("L");
                        lastLeft = numbers[i] + "";
                    }
                } else if(leftDistance < rightDistance) {
                    answerBuilder.append("L");
                    lastLeft = numbers[i] + "";
                } else {
                    answerBuilder.append("R");
                    lastRight = numbers[i] + "";
                }
            }
        }
        return answerBuilder.toString();
    }
}
