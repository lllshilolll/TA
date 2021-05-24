package animal;

public class Bear extends Carnivorous implements Swim, Run {
    public Bear(String name) {
        super(name, 4);
    }

    @Override
    public void run() {
        System.out.println("Медведь бегает");
    }

    @Override
    public void swim() {
        System.out.println("Медведь плавает");

    }
}