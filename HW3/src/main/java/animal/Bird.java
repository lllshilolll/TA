package animal;

public class Bird extends Herbivore implements Fly, Voice {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Птица летает");
    }

    @Override
    public String voice() {
        return "Чирик-чирик";
    }
}
