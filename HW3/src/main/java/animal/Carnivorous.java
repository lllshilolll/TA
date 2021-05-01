package animal;

import food.Food;
import food.Meat;
import food.WrongFoodException;

abstract public class Carnivorous extends Animal {

    public Carnivorous(String name) {
        super(name);
    }

    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Meat) throw new WrongFoodException(getName() + " должн есть мясо!");
        System.out.println(getName() + " cъел " + food.getFood());
    }
}
