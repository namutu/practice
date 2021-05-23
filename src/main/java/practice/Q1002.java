package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1002 {

    public static void main(String[] args) {
//        3
//        0 0 13 40 0 37
//        0 0 3 0 7 4
//        1 1 1 1 1 5

//        2
//        1
//        0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int loop = Integer.parseInt(br.readLine());
            int[] answer = new int[loop];
            for(int i=0 ; i<loop ; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                person one = new person();
                one.x = Integer.parseInt(st.nextToken());
                one.y = Integer.parseInt(st.nextToken());
                one.marin = Integer.parseInt(st.nextToken());
                person two = new person();
                two.x = Integer.parseInt(st.nextToken());
                two.y = Integer.parseInt(st.nextToken());
                two.marin = Integer.parseInt(st.nextToken());

                int count = solution(one, two);
                answer[i] = count;
            }
            for(int i=0 ; i<loop ; i++) {
                System.out.println(answer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int solution(person one, person two){
        if(one.x== two.x && one.y == two.y && one.marin == two.marin) return -1;
        double degree = Math.sqrt(Math.pow(one.x-two.x, 2)+Math.pow(one.y-two.y, 2));
        double marinDegree = one.marin + two.marin;
//        System.out.println("one.x : " + one.x + ", one.y : " + one.y + ", one.marin : " + one.marin);
//        System.out.println("two.x : " + two.x + ", two.y : " + two.y + ", two.marin : " + two.marin);
//        System.out.println("degree : " + degree + ", marinDegree : " + marinDegree);
        //CASE 1-1 : 두 원이 만나지 않는 경우, 두 원이 닿지 않는 경우
        if(degree > marinDegree) {
//            System.out.println("01 one("+one.x+","+one.y+") two"+two.x+","+two.y+")");
            return 0;
        }
        else if((degree+one.marin < two.marin) || degree+two.marin < one.marin) {
//            System.out.println("02 one("+one.x+","+one.y+") two("+two.x+","+two.y+")");
            return 0;
        }
        //CASE 2-1 : 두 원이 한점에서 만나는 경우, 두 원이 중간지점에서 만남
        else if(degree == marinDegree) {
//            System.out.println("11 one("+one.x+","+one.y+") two("+two.x+","+two.y+")");
            return 1;
        }
        //CASE 2-2 : 두 원이 한점에서 만나는 경우, 한 원이 다른 한 원 안에 포함되어 한점에서 만남
        else if((degree+one.marin == two.marin) || (degree+two.marin == one.marin)) {
//            System.out.println("12 one("+one.x+","+one.y+") two("+two.x+","+two.y+")");
            return 1;
        }
        //CASE 3 : 두 원이 두 점에서 만나는 경우
//        else if(degree < marinDegree && (degree+one.marin < two.marin || degree+two.marin < one.marin)) {
        else if((one.marin > degree-two.marin && one.marin < degree+two.marin) || (two.marin > degree-one.marin && two.marin < degree + one.marin)) {
//            System.out.println("31 one("+one.x+","+one.y+") two("+two.x+","+two.y+")");
            return 2;
        } else {
//            System.out.println("32 one("+one.x+","+one.y+") two("+two.x+","+two.y+")");
            return -1;
        }
    }
    static class person {
        double x;
        double y;
        double marin;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getMarin() {
            return marin;
        }

        public void setMarin(double marin) {
            this.marin = marin;
        }
    }
}
