package animal;

import Aviary.SizeAviary;
import food.Food;
import food.WrongFoodException;

import java.util.Objects;

public abstract class Animal {
    String name;
    SizeAviary sizeAviary;

    public Animal(String name) {
        this.name = name;
        sizeAviary = SizeAviary.MEDIUM;
    }

    public abstract void eat(Food food) throws WrongFoodException;

    public String getName() {
        return name;
    }

    public SizeAviary getSizeAviary() {
        return sizeAviary;
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
