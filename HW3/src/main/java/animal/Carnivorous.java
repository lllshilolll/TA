package animal;

import Aviary.SizeAviary;
import food.Food;
import food.Meat;
import food.WrongFoodException;

abstract public class Carnivorous extends Animal {
    SizeAviary sizeAviary;
    public Carnivorous(String name) {
        super(name);
        sizeAviary = SizeAviary.SMALL;
    }

    public void eat(Food food) throws WrongFoodException {
        if (food instanceof Meat) throw new WrongFoodException(getName() + " должн есть мясо!");
        System.out.println(getName() + " cъел " + food.getFood());
    }
}
