import animal.*;
import food.*;

public class Zoo {
    public static void main(String[] args) {
        Bear bear = new Bear("Мишка");
        Bird bird = new Bird("Воробушек");
        Duck duck = new Duck("Уточка");
        Fish fish = new Fish("Рыбка");
        Tiger tiger = new Tiger("Тигр");
        Wolf wolf = new Wolf("Волк");

        Berries berries = new Berries("малина");
        Chicken chicken = new Chicken("курица");
        Leaves leaves = new Leaves("листья");
        Mouse mouse = new Mouse("мышь");
        Plankton plankton = new Plankton("рыба");
        Seaweed seaweed = new Seaweed("водоросли");

        Worker worker = new Worker();

        worker.feed(wolf, chicken);
        worker.feed(fish, seaweed);
        worker.feed(duck, mouse);
        worker.feed(tiger, leaves);
        worker.getVoice(bird);
        worker.getVoice(wolf);

        Swim[] pool = {bear, duck, fish, tiger};
        for (int i = 0; i < pool.length; i++) {
            pool[i].swim();
        }
    }
}