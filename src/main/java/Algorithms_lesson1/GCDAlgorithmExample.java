package Algorithms_lesson1;

// Алгоритм нахождение общего делителя
public class GCDAlgorithmExample {
    public static void main(String[] args) {

        int a = 12334;
        int b = 3456
                ;
        // метод вызывает время работы алгоритма
        long start = System.currentTimeMillis();
        greatestCommonDeliver(a, b);
        long end = System.currentTimeMillis();
        System.out.println("Euclidean algorithm = " + (end - start));

        // метод вызывает время работы алгоритма
        start = System.currentTimeMillis();
        bruteForceAlgorithm(a, b);
        end = System.currentTimeMillis();
        System.out.println("Brute force algorithm = " + (end - start));

    }
    // Эвклидов алгоритм метод нахождения общего делителя
    public static void greatestCommonDeliver(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        System.out.println("GCD = " + a);
    }

    // Силовой метод нахождения общего делителя
    public static void bruteForceAlgorithm(int a, int b){
        for (int i = Math.min(a,b); i > 0  ; i--) {
            if(a % 1 == 0 && b % 1 ==0){
                System.out.println("GCD = " + i );
                break;
            }
        }
    }

}
