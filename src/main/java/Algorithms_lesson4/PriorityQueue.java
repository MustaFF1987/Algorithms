package Algorithms_lesson4;

import java.util.Comparator;

public class PriorityQueue {

    public static void main(String[] args) {

        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>(Comparator.reverseOrder());
        queue.add(7);
        queue.add(6);
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());


    }

}
