package Algorithms_lesson1;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

// Алгоритмы поиска (Последовательный и Бинарный)
public class SearchExample {
    public static void main(String[] args) {

    int[] ints = new int[]{1, 2, 4, 7, 1, 8, 4, 0};
        int key = 2;

    int index = searchSequentally(ints, key);
        System.out.println(index);

        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        index = binarySearch(ints, key);
        System.out.println(index);
    }

    // Алгоритм Бинарного поиска
    public static int binarySearch(int[] ints,int key){
//        Arrays.sort(ints);
        int start = 0;
        int end = ints.length - 1;
        int current = end / 2;
        while (start <= end){
            if(ints[current] ==  key) return current;
            if(ints[current] > key) end = current - 1;
            if(ints[current] < key) start = current + 1;
            current = start + (end-start) / 2;
        }
        return -1;
    }
    // Алгоритм Последовательного поиска
    private static int searchSequentally(int[] ints, int key){
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] == key) return i;

        }
        return -1;
    }


}


