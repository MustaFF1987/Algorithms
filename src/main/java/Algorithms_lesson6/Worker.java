package Algorithms_lesson6;

import java.util.Objects;

public class Worker {

    private String name;
    private int age;

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return age == worker.age && name.equals(worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
