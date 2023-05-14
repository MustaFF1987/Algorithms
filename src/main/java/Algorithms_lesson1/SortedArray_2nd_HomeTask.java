package Algorithms_lesson1;

import java.sql.SQLOutput;
import java.util.Arrays;

/* Дан отсортированный массив, в котором все элементы встречаются
дважды (один за другим), а один элемент появляется только один раз.
Найдите этот элемент. Определите асимптотическую сложность алгоритма. */

public class SortedArray_2nd_HomeTask {

    public static void main(String[] args) {

        int[] array = {1,1,2,2,3,3,4,4,5,5,6,7,7,8,8,9,9};

            System.out.println("Массив целых чисел: " + Arrays.toString(array));

            System.out.println("Не повторяющийся элемент: " + findSingleElement(array));

    }
    public static int findSingleElement(int[] arr) {
        // определяем начало и конец массива
        int head = 0;
        int tail = arr.length - 1;

        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (arr[mid] != arr[mid + 1]) {
                tail = mid - 1;
            } else {
                head = mid + 2;
            }
        }
        return arr[head];
    }

}
/* O(log n) — логарифмическая сложность */