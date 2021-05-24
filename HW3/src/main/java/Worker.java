import animal.Animal;
import animal.Voice;
import food.Food;
import food.WrongFoodException;

public class Worker {
    public void feed(Animal animal, Food food) throws WrongFoodException {
        animal.eat(food);
    }

    public void getVoice(Animal animal) {
        Voice voice = (Voice) animal;
        System.out.println(voice.voice());
    }
}
