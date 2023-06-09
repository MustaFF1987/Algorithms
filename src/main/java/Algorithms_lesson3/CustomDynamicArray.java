package Algorithms_lesson3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomDynamicArray implements Iterable<Integer> {
    private int[] array;
    private int size;
    private int count;
    private int currentIndex;


    public CustomDynamicArray(int capacity){
        array = new int[capacity];
        size = capacity;
        count = 0;
    }

    public void add(int data){
        if (count >= size){
            growSize();
        }
        array[count++] = data;
    }

    public void set(int data, int index) {
        if (index >= count) throw new ArrayIndexOutOfBoundsException();
        array[index] = data;
    }

    public void addAt(int data, int index){
        if (index >= count) throw new ArrayIndexOutOfBoundsException();
        if (count >= size) {
            growSize();
        }
        for (int i = count - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = data;
        count++;
    }

    public void remove(){
        if (count == 0) throw new RuntimeException("No elements present");
        count--;
    }

    public void removeAt(int index) {
        if (index >= count) throw new ArrayIndexOutOfBoundsException();
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public void shrinkSize(){
        if (count < size){
            int[] newArray = new int[count];
            for (int i = 0; i < count; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            size = count;
        }
    }

    public int get(int index){
        if (index >= count) throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    public void clear(){
        count = 0;
    }

    public boolean contains(int element){
        for (int i = 0; i < count; i++) {
            if (element == array[i]) return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return count  == 0;
    }

    private void growSize() {
        int[] newArray = new int[size * 2];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = newArray.length;
    }

    public static void main(String[] args) {
        CustomDynamicArray dynamicArray = new CustomDynamicArray(2);
        dynamicArray.printInnerStructure();
        dynamicArray.add(1);
//        dynamicArray.printInnerStructure();
//        dynamicArray.add(2);
//        dynamicArray.printInnerStructure();
//        dynamicArray.add(3);
//        dynamicArray.printInnerStructure();
//        dynamicArray.add(4);
//        dynamicArray.printInnerStructure();
//        dynamicArray.add(5);
//        dynamicArray.printInnerStructure();
//        dynamicArray.add(6);
//        dynamicArray.printInnerStructure();

        dynamicArray.addAt(100, 0);
        dynamicArray.printInnerStructure();

        dynamicArray.set(101,0);
        dynamicArray.printInnerStructure();

        System.out.print(dynamicArray.hasNext());
        System.out.println(" : " + dynamicArray.next());

        System.out.print(dynamicArray.hasNext());
        System.out.println(" : " + dynamicArray.next());

        System.out.print(dynamicArray.hasNext());
        System.out.println(" : " + dynamicArray.next());

    }

    public void printInnerStructure() {
        System.out.println("CustomDynamicArray{" + "array=" + Arrays.toString(array)
                + ", size=" + size + ", count=" + count + '}');
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count; i++) {
            s = s + " " + array[i];
        }
        return "CustomDynamicArray{" + "array=" + s + ", count=" + count + '}';
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

        public boolean hasNext() {
            return currentIndex < count;
        }

        public int next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex++];
        }
}
