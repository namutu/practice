package leetcode.medium;

import java.util.HashMap;

class TimpMap {
    HashMap<String, HashMap<Integer, String>> data;
    public TimpMap() {
        data = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        if(data.containsKey(key)) {
//            System.out.println("1 key : " + key + ", value : " + value + ", timestamp : " + timestamp);
            data.get(key).put(timestamp, value);
        } else {
//            System.out.println("2 key : " + key + ", value : " + value + ", timestamp : " + timestamp);
            HashMap<Integer, String> timeData = new HashMap<>();
            timeData.put(timestamp, value);
            data.put(key, timeData);
        }
    }
    public String get(String key, int timestamp) {
        HashMap<Integer, String> timeData = data.get(key);
//        System.out.println("timeData : " + timeData.toString());
        if(timeData.get(timestamp) != null) return timeData.get(timestamp);
        else {
            for(int i=timestamp ; i>=1 ; i--) {
                if(timeData.get(i) != null) return timeData.get(i);
            }
        }
        return "";
    }
}
public class Q981 {
    public static void main(String[] args) {
//        ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
//        TimpMap timpMap = new TimpMap();
//        timpMap.set("foo", "bar", 1);
//        System.out.println(timpMap.get("foo", 1));
//        System.out.println(timpMap.get("foo", 3));
//        timpMap.set("foo", "bar2", 4);
//        System.out.println(timpMap.get("foo", 4));
//        System.out.println(timpMap.get("foo", 5));

//        ["TimeMap","set","set","get","get","get","get","get"]
//        , inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
//        [null,null,null,"","high","high","low","low"]
        TimpMap timpMap = new TimpMap();
        timpMap.set("love", "high", 10);
        timpMap.set("love", "low", 20);
        System.out.println(timpMap.get("love", 5));
        System.out.println(timpMap.get("love", 10));
        System.out.println(timpMap.get("love", 15));
        System.out.println(timpMap.get("love", 20));
        System.out.println(timpMap.get("love", 25));
    }
}
















