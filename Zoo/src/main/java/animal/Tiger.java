package animal;

public class Tiger extends Carnivorous implements Swim, Run {
    public Tiger(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Тигр бегает");
    }

    @Override
    public void swim() {
        System.out.println("Тигр плавает");
    }
}
