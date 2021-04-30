package Aviary;

import animal.Animal;
import java.util.HashMap;

public class Aviary<T extends Animal> {
    private SizeAviary sizeAviary;
    private final HashMap<String, T> mapAnimals = new HashMap<>();

    public Aviary(SizeAviary sizeAviary) {
        this.sizeAviary = sizeAviary;
    }

    public Aviary() {
        sizeAviary = sizeAviary.MEDIUM;
    }

    public void addAnimal(String name, T animal, SizeAviary sizeAviary) {
        if (this.sizeAviary == sizeAviary) {
            mapAnimals.put(name, animal);
        }
    }

    public void deleteAnimal(String name) {
        mapAnimals.remove(name);
    }

    public void printAnimals() {
        for (String name : mapAnimals.keySet()) {
            System.out.println(name + " " + getAnimal(name));
        }
    }
    public T getAnimal(String name) {
        return mapAnimals.get(name);
    }

    public String getSizeAviary ()
    {
        return sizeAviary.name();
    }

}
