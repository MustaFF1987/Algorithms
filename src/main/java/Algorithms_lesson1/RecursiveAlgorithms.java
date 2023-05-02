package Algorithms_lesson1;

// Рекурсивный функции (когда функция вызывает саму себя)
public class RecursiveAlgorithms {
    public static void main(String[] args) {

//       f(10);
        System.out.println(sumNumbers(5));
        System.out.println("---------------");
        System.out.println((sumNumbers2(5)));
        System.out.println("---------------");

        long n = 10;
        long fib = fibonacci(n);
        System.out.println("fibonacci(" + n + ") = " + fib);

    }

    //рекурсивные функции, которы ссылаются друг на друга
    private static void f1(int n){
       System.out.println(n);
       f2(n);
    }

   private static void f2(int n){
     n++;
     if(n > 20) return;
      f1(n);
    }

    // рекурсивный метод

    // функция генерирует n член последовательности fibonacci O*(n2) - экспоненциальный алгоритм  - не эффективный
    // 0 1 1 2 3 5 8 13 21
    // fibonacci(n)
    // f(1) = 0
    // f(2) = 1
    // f(3) = 2
    // f(4) = 3
    // f(5) = 4

    public static long fibonacci(long n) {
        if (n == 1) return 0;
        if(n == 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }


    // рекурсивный метод суммы всех чисел (медленнее чем алгоритмы цикличекские)
    private static int sumNumbers(int i){
        if(i == 1) return 1;
        int result = i + sumNumbers(i - 1);
        return result;
    }
    // последовательный метод суммы всех чисел (более эффективный, т.к. занимает меньше памяти при вычислении)
    private static int sumNumbers2(int n){
        int sum = 0;
        for (int j = 1; j <= n; j++) {
            sum = sum + j;
        }
        return sum;
    }


    public static void f(int i){
        System.out.println(i++);
        if(i > 10) return;  // условие, которое определяет по которому я могу выйти из рекурсии
        f(i);
    }
}
