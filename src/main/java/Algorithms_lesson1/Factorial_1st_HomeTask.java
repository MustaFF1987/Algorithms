package Algorithms_lesson1;

/*  Рекурсивная функция вычисления факториала factorial(n)
 - произведения всех чисел до n включительно */

/* Факториал натурального числа n определяется
как произведение всех натуральных чисел от 1 до n включительно:
 */
public class Factorial_1st_HomeTask {
        public static int factorial(int n) {
            if (n <= 1) { // базовый случай
                return 1;
            } else {
                return n * factorial(n - 1); // рекурсивный случай
            }
        }
    /* вычислительная сложность этого алгоритма равна O(N). */

    public static void main(String[] args) {

        System.out.println("Факториал числа 3: " + factorial(3));
        System.out.println("Факториал числа 5: " + factorial(5));
        System.out.println("Факториал числа 7: " + factorial(7));
        System.out.println("Факториал числа 10: " + factorial(10));

    }
}


