package animal;

public class Duck extends Herbivore implements Swim, Fly {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Утка летает");
    }

    @Override
    public void swim() {
        System.out.println("Утка плавает");
    }
}
