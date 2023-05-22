package Algorithms_lesson3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {

        long startTime;
        long endTime;
        long duration;

        List<Integer> arrayList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList добавление: " + duration);


        List<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            linkedList .add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList добавление: " + duration);
        }
    }

