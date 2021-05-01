package animal;

import food.Food;
import food.Grass;
import food.WrongFoodException;

abstract public class Herbivore extends Animal {

    public Herbivore(String name) {
        super(name);
    }

    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Grass) throw new WrongFoodException(getName() + " должн есть траву!");
        System.out.println(getName() + " cъел " + food.getFood());
    }
}
