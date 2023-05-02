package Algorithms_lesson1;

import java.util.Arrays;
import java.util.Random;

public class SortExamples {
    public static void main(String[] args) {

        //int[] ints = new int[]{1, 4, 5, 1, 2, 4, 7, 0, 2, 3};

        // Добавляем значения в массив с помощью метода Java Random
        int[] ints = new int[100_000];
        Random random = new Random();
        for (int i = 0; 1 < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }

        long start = System.nanoTime();
        sortBruteForce(ints);
        long end = System.nanoTime();
        System.out.println("Time elapsed: " + (end - start));

//        System.out.println(Arrays.toString(ints));
        for (int i = 0; i < ints.length; i++)
            ints[i] = random.nextInt(100);

        start = System.nanoTime();
        Arrays.sort(ints);
        end = System.nanoTime();
        System.out.println("Time elapsed: " + (end - start));
    }

    // Сортировка 'пузырьковая'
    static void sortBruteForce(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]){
                    int tmp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = tmp;
                }
            }
        }
    }
}