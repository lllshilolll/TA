package model;

public class Kotik {
    private int prettiness;
    private int weight;
    private String name;
    private String meow;
    //числовая переменная экземпляра показывающая степень сытости котика
    private int foodWeight;
    private static int count;

    public Kotik() {
        count++;
    }

    public Kotik(int prettiness, int weight, String name, String meow) {
        this.prettiness = prettiness;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
        foodWeight = 0;
        count++;
    }

    public void setKotik(int prettiness, int weight, String name, String meow) {
        this.prettiness = prettiness;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
        foodWeight = 0;
    }

    public boolean isAlive() {
        if (foodWeight <= 0) {
            return false;
        }
        return true;
    }


    public void play() {
        if (isAlive() == false) {
            System.out.println("Кот голодный, покорми кота!");
            eat();
        } else {
            foodWeight = foodWeight - 5;
            System.out.println("Кот играет");
        }
    }

    public void sleep() {
        if (isAlive() == false) {
            System.out.println("Кот голодный, покорми кота!");
            eat();
        } else {
            foodWeight = foodWeight - 1;
            System.out.println("Кот спит");
        }
    }

    public void chaseMouse() {
        if (isAlive() == false) {
            System.out.println("Кот голодный, покорми кота!");
            eat();
        } else {
            foodWeight = foodWeight - 2;
            System.out.println("Кот поймал мышку");
        }
    }

    public void pee() {
        if (isAlive() == false) {
            System.out.println("Кот голодный, покорми кота!");
            eat();
        } else {
            foodWeight = foodWeight - 2;
            System.out.println("Кот сходил в туалет");
        }
    }

    public void drink() {
        foodWeight = foodWeight + 5;
        System.out.println("Кот попил");
    }

    public void eat() {
        eat(10, "fish");
    }

    public void eat(int amount) {
        foodWeight = foodWeight + amount;
        System.out.println("Кот поел " + amount + " еды");
    }

    public void eat(int amount, String food) {
        foodWeight = foodWeight + amount;
        System.out.println("Кот поел " + amount + " " + food);
    }

    public void liveAnotherDay() {
        for (int i = 0; i < 24; i++) {
            //рандомное число от 1 до 6
            int rand = (int) (Math.random() * 5) + 1;
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

    public int getFoodWeight() {
        return foodWeight;
    }
}

