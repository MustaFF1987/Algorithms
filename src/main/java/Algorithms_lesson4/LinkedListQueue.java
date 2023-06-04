package Algorithms_lesson4;

import java.util.*;

    public class LinkedListQueue<T> {

        private LinkedList<Integer> list;


        public LinkedListQueue() {
            list = new LinkedList<>();
        }

        public void enqueue(int element) {
            list.addLast(element);
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return list.removeFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public int size() {
            return list.size();
        }

        public static void main(String[] args) {
            LinkedListQueue<Integer> queue = new LinkedListQueue<>();
            queue.enqueue(5);
            queue.enqueue(10);
            queue.enqueue(15);

            int firstElement = queue.dequeue();
            System.out.println(firstElement);

            boolean isEmpty = queue.isEmpty();
            System.out.println(isEmpty);

            System.out.println(queue.size());
        }
    }

