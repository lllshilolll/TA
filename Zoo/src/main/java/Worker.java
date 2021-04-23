import animal.Animal;
import animal.Voice;
import food.Food;

public class Worker {
    public void feed(Animal animal, Food food) {
        animal.eat(food);
    }

    public void getVoice(Voice animal) {
        System.out.println(animal.voice());
    }
}
