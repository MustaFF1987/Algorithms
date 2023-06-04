package Algorithms_lesson4;

import java.util.*;

public class LinkedListQueueTeacher {

    private int size;

    private Node first;

    private Node last;

    private class Node {
        Node next;
        String item;
     }

    public LinkedListQueueTeacher(){
        size = 0;
        first = null;
        last = null;

    }

    public void enqueue(String item){
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
        first = node;
        last = node;
        } else {
            last.next = node;
            node = last;
        }
      size++;
    }

    public String dequeue(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        Node node = first;
        first = first.next;
        size--;
        return node.item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

      public static void main(String[] args) {

        LinkedListQueueTeacher list = new LinkedListQueueTeacher();

        list.enqueue("ABC");
        list.enqueue("GTY");

        System.out.println(list.isEmpty());
        System.out.println(list.size);
        System.out.println(list.dequeue());
        System.out.println(list.size);
        System.out.println(list.dequeue());
        System.out.println(list.size);
        System.out.println(list.isEmpty());

    }
}
