package animal;

import Aviary.SizeAviary;
import food.Food;

public abstract class Animal {
    String name;
    SizeAviary sizeAviary;

    public Animal(String name) {
        this.name = name;
        sizeAviary = SizeAviary.MEDIUM;
    }

    public abstract void eat(Food food);

    public String getName() {
        return name;
    }

    public SizeAviary getSizeAviary() {
        return sizeAviary;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
