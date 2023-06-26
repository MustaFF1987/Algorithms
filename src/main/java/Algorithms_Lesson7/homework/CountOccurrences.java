package Algorithms_Lesson7.homework;

    /*Имея отсортированный массив arr[] и число x, напишите функцию, которая подсчитывает вхождения x в arr[]. Ожидаемая временная сложность O(Log n)
arr[] = {1, 1, 2, 2, 2, 2, 3,}
x = 2
Вывод: 4 раза*/

public class CountOccurrences {
    public static int countOccurrences(int[] arr, int x) {
        int firstIndex = findFirstIndex(arr, x);

        if (firstIndex == -1) {
            return 0; // Элемент не найден
        }

        int lastIndex = findLastIndex(arr, x);

        return lastIndex - firstIndex + 1;
    }

    private static int findFirstIndex(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static int findLastIndex(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;

        int occurrences = countOccurrences(arr, x);
        System.out.println("Occurrences of " + x + ": " + occurrences);
    }
}


