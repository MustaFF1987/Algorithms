package Algorithms_lesson5;

import java.util.*;

public class UseTrees {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();

        map.put("A ", " value A");
        map.put("B ", " value B");
        map.put("C ", " value C");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String, String> e : map.entrySet()){
            System.out.println(e);
        }

        Set<String> set = new TreeSet<>();

    }

}
