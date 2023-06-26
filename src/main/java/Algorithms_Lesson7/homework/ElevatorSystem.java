package Algorithms_Lesson7.homework;

    /*1 уровень сложности: 1. Задача: вызов лифта
В доме два лифта
реализовать алгоритм отправки наиближайшего на вызывающий этаж.

алгоритм будет применяться в домах разной этажности.

Пример:
в доме 19 этажей
работают лифт А и лифт В
лифт А находиться на 0 этаже
лифт В находиться на 8 этаже
на вход: 1
отправляем лифт А*/

public class ElevatorSystem {
    private int numberOfFloors;
    private Elevator elevatorA;
    private Elevator elevatorB;

    public ElevatorSystem(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        this.elevatorA = new Elevator("A");
        this.elevatorB = new Elevator("B");
    }

    public void requestElevator(int floor) {
        Elevator nearestElevator = getNearestElevator(floor);
        nearestElevator.moveToFloor(floor);
    }

    private Elevator getNearestElevator(int floor) {
        int distanceA = Math.abs(elevatorA.getCurrentFloor() - floor);
        int distanceB = Math.abs(elevatorB.getCurrentFloor() - floor);

        if (distanceA <= distanceB) {
            return elevatorA;
        } else {
            return elevatorB;
        }
    }

    private class Elevator {
        private String name;
        private int currentFloor;

        public Elevator(String name) {
            this.name = name;
            this.currentFloor = 0;
        }

        public int getCurrentFloor() {
            return currentFloor;
        }

        public void moveToFloor(int floor) {
            System.out.println("Elevator " + name + " is moving from floor " + currentFloor + " to floor " + floor);
            currentFloor = floor;
            System.out.println("Elevator " + name + " has arrived at floor " + currentFloor);
        }
    }

    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(19);
        elevatorSystem.requestElevator(5);
    }
}
