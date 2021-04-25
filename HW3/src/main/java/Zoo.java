import Aviary.Aviary;
import animal.*;
import food.*;

public class Zoo {
    public static void main(String[] args) throws WrongFoodException {
        Carnivorous bear = new Bear("Мишка");
        Herbivore bird = new Bird("Воробушек");
        Herbivore duck = new Duck("Уточка");
        Herbivore fish = new Fish("Рыбка");
        Carnivorous tiger = new Tiger("Тигр");
        Carnivorous wolf = new Wolf("Волк");

        Food berries = new Berries("малина");
        Food chicken = new Chicken("курица");
        Food leaves = new Leaves("листья");
        Food mouse = new Mouse("мышь");
        Food plankton = new Plankton("рыба");
        Food seaweed = new Seaweed("водоросли");

        Worker worker = new Worker();

        worker.feed(wolf, chicken);
        worker.feed(fish, seaweed);
        worker.feed(duck, mouse);
        worker.feed(tiger, leaves);
        worker.getVoice(bird);
        worker.getVoice(wolf);

        Aviary<Herbivore> aviaryHerb = new Aviary<Herbivore>();
        Aviary<Carnivorous> aviaryCarn = new Aviary<Carnivorous>();
        aviaryHerb.addAnimalInAviary(bird.getName(), bird, bird.getSizeAviary());
        aviaryHerb.addAnimalInAviary(duck.getName(), duck, duck.getSizeAviary());
        aviaryHerb.addAnimalInAviary(fish.getName(), fish, fish.getSizeAviary());
        aviaryCarn.addAnimalInAviary(bear.getName(), bear, bear.getSizeAviary());
        aviaryCarn.addAnimalInAviary(tiger.getName(), tiger, tiger.getSizeAviary());
        aviaryCarn.addAnimalInAviary(wolf.getName(), wolf, wolf.getSizeAviary());

        aviaryHerb.printAnimals();
        System.out.println("\n");
        aviaryCarn.printAnimals();
        System.out.println("\n");
        aviaryCarn.deleteAnimalInAviary("Мишка");
        aviaryCarn.printAnimals();

        Animal[] pool = {bear, duck, fish, tiger};
        for (int i = 0; i < pool.length; i++) {
            Swim swim = (Swim) pool[i];
            swim.swim();
        }
    }
}