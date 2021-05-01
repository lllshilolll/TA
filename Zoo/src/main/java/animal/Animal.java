package animal;

import food.Food;

public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat(Food food);

    public String getName() {
        return name;
    }

}
