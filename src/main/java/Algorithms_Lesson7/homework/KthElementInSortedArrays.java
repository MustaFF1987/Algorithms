package Algorithms_Lesson7.homework;
 /*Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
который будет находиться на k-й позиции в конечном отсортированном массиве.
Массив 1 - 100 112 256 349 770
Массив 2 - 72 86 113 119 265 445 892
к = 7
Вывод : 256
Окончательный отсортированный массив -
72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
7-й элемент этого массива равен 256.*/

public class KthElementInSortedArrays {
    public static int findKthElement(int[] array1, int[] array2, int k) {
        int m = array1.length;
        int n = array2.length;
        int i = 0; // индекс для массива array1
        int j = 0; // индекс для массива array2
        int count = 0; // счетчик для отслеживания текущей позиции

        while (i < m && j < n) {
            if (array1[i] < array2[j]) {
                count++;
                if (count == k) {
                    return array1[i];
                }
                i++;
            } else {
                count++;
                if (count == k) {
                    return array2[j];
                }
                j++;
            }
        }

        // Если один из массивов исчерпан, продолжаем с другим массивом
        while (i < m) {
            count++;
            if (count == k) {
                return array1[i];
            }
            i++;
        }

        while (j < n) {
            count++;
            if (count == k) {
                return array2[j];
            }
            j++;
        }

        return -1; // Если k выходит за границы массивов
    }

    public static void main(String[] args) {
        int[] array1 = {100, 112, 256, 349, 770};
        int[] array2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;

        int result = findKthElement(array1, array2, k);
        System.out.println("Kth element: " + result);
    }
}
