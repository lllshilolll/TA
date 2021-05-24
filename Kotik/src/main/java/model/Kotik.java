package model;

public class Kotik {
    private int prettiness;
    private int weight;
    private String name;
    private String meow;
    //числовая переменная экземпляра показывающая степень сытости котика
    private int satiety;
    private static int count;

    public Kotik() {
        count++;
    }

    public Kotik(int prettiness, int weight, String name, String meow) {
        this.prettiness = prettiness;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
        satiety = 0;
        count++;
    }

    public void setKotik(int prettiness, int weight, String name, String meow) {
        this.prettiness = prettiness;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
        satiety = 0;
    }

    public boolean play() {
        if (satiety <= 0) {
            System.out.println("Кот голодный, покорми кота!");
            return false;
        }
        satiety = satiety - 5;
        System.out.println("Кот играет");
        return true;
    }

    public boolean sleep() {
        if (satiety <= 0) {
            System.out.println("Кот голодный, покорми кота!");
            return false;
        }
        satiety = satiety - 1;
        System.out.println("Кот спит");
        return true;
    }

    public boolean chaseMouse() {
        if (satiety <= 0) {
            System.out.println("Кот голодный, покорми кота!");
            return false;
        }
        satiety = satiety - 2;
        System.out.println("Кот поймал мышку");
        return true;
    }

    public boolean pee() {
        if (satiety <= 0) {
            System.out.println("Кот голодный, покорми кота!");
            return false;
        }
        satiety = satiety - 2;
        System.out.println("Кот сходил в туалет");
        return true;
    }

    public void drink() {
        satiety = satiety + 5;
        System.out.println("Кот попил");
    }

    public void eat() {
        eat(10, "fish");
    }

    public void eat(int amount) {
        satiety = satiety + amount;
        System.out.println("Кот поел " + amount + " еды");
    }

    public void eat(int amount, String food) {
        satiety = satiety + amount;
        System.out.println("Кот поел " + amount + " " + food);
    }

    public void liveAnotherDay() {
        for (int i = 0; i < 24; i++) {
            //рандомное число от 1 до 6
            int rand = (int) (Math.random() * 6) + 1;
            switch (rand) {
                case 1:
                    play();
                    break;
                case 2:
                    sleep();
                    break;
                case 3:
                    chaseMouse();
                    break;
                case 4:
                    pee();
                    break;
                case 5:
                    drink();
                    break;
                case 6:
                    eat();
                    break;
            }
        }

    }

    public static int getCount() {
        return count;
    }

    public int getPrettiness() {
        return prettiness;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getMeow() {
        return meow;
    }

    public int getSatiety() {
        return satiety;
    }
}

