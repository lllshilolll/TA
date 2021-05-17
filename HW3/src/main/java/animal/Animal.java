package animal;

import food.Food;
import food.WrongFoodException;

import java.util.Objects;

public abstract class Animal {
    String name;
    protected int size;


    public Animal(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public abstract void eat(Food food) throws WrongFoodException;

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return this.name.equals(animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
