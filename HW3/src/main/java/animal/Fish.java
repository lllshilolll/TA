package animal;

public class Fish extends Herbivore implements Swim {

    public Fish(String name) {
        super(name, 2);
    }

    @Override
    public void swim() {
        System.out.println("Рыба плавает");
    }
}
