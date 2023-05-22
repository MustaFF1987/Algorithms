package Algorithms_lesson2.homework;

/* На вершине лесенки, содержащей N ступенек, находится мячик, который начинает прыгать по ним вниз, к основанию.
Мячик может прыгнуть на следующую ступеньку, на ступеньку через одну или через 2.
(То есть, если мячик лежит на 8-ой ступеньке, то он может переместиться на 5-ую, 6-ую или 7-ую.) */

public class homework_ball {
    public static void main(String[] args) {

        int n = 3; // кол-во ступеней
        int count = countRoutes(n);

        System.out.println("Число всевозможных «маршрутов» мячика с вершины на землю: " + count);
    }

    public static int countRoutes(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            return countRoutes(n - 1) + countRoutes(n - 2) + countRoutes(n - 3);
                }
            }
        }