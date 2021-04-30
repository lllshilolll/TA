package animal;

import Aviary.SizeAviary;

public class Tiger extends Carnivorous implements Swim, Run {
    SizeAviary sizeAviary;

    public Tiger(String name) {
        super(name);
        sizeAviary = SizeAviary.HUGE;
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
