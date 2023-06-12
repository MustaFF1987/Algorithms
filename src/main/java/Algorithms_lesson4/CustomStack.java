package Algorithms_lesson4;

import java.util.Stack;

public class CustomStack {

    private int[] array;
    private int count;

    public CustomStack(int size) {
        array = new int[size]; // создание стека будет стоить O(n)
        count = 0;
    }

    // смотрит на верхний элемент stack
    // O(1)
    public int peek(){
        if (count == 0) throw new RuntimeException("Stack is empty");
        return array[count - 1];
    }

    // смотрит на верхний элемент и удаляет его
    // O(1)
    public int pop(){
        if (count == 0) throw new RuntimeException("Stack is empty");
        return array[--count];
    }

    // добавляет элемент в stack
    // O(1)
    public void push(int element){
        if(count == array.length) throw new RuntimeException("Stack is full");
        array[count++] = element;
    }

    public int search(int element) {
        for (int i = 0; i < array.length; i++)
        {
            if(array[i] == element)
                return i;
        }
        return -1;
    }



    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        Stack<String> libraryStack = new Stack<>();
        libraryStack.push("A");
        libraryStack.push("B");
        libraryStack.push("C");
//        System.out.println(libraryStack.pop());
        System.out.println(stack.search(5));
        System.out.println(libraryStack.search("C"));

    }


}
