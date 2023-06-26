package Algorithms_lesson6;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Factory {

    private int cost;
    private String name;
    private List<Worker> workerList;

    public Factory(int cost, String name, List<Worker> workerList) {
        this.cost = cost;
        this.name = name;
        this.workerList = workerList;
    }


    public static void main(String[] args) {
        Factory a = new Factory(100, "Cars factory",
                Arrays.asList(new Worker("Ivan", 35), new Worker("Peter", 55)));
        Factory b = new Factory(100, "Cars factory",
                Arrays.asList(new Worker("Ivan", 35), new Worker("Peter", 55)));

        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factory factory)) return false;
        return cost == factory.cost && name.equals(factory.name) && workerList.equals(factory.workerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, name, workerList);
    }
}
