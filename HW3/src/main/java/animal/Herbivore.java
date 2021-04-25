package animal;

import food.Food;
import food.Grass;

abstract public class Herbivore extends Animal {
    public Herbivore(String name) {
        super(name);
    }

    public void eat(Food food) {
        if (food instanceof Grass == false) {
            System.out.println(getName() + " должн есть траву!");
            return;
        }
        System.out.println(getName() + " cъел " + food.getFood());
    }
}
