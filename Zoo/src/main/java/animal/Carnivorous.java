package animal;

import food.Food;
import food.Meat;

abstract public class Carnivorous extends Animal {
    public Carnivorous(String name) {
        super(name);
    }

    public void eat(Food food) {
        if (!(food instanceof Meat)) {
            System.out.println(getName() + " должн есть мясо!");
            return;
        }
        System.out.println(getName() + " cъел " + food.getFood());
    }
}
