package Aviary;

import java.util.HashMap;

public class Aviary<T> {
    private SizeAviary sizeAviary;

    public Aviary(SizeAviary sizeAviary) {
        this.sizeAviary = sizeAviary;
    }

    public Aviary() {
        sizeAviary = sizeAviary.MEDIUM;
    }

    private final HashMap<String, T> mapAnimals = new HashMap<>();

    public void addAnimalInAviary(String name, T animal, SizeAviary sizeAviary) {
        if (this.sizeAviary == sizeAviary) {
            mapAnimals.put(name, animal);
        }
    }

    public void deleteAnimalInAviary(String name) {
        mapAnimals.remove(name);
    }

    public T getAnimal(String name) {
        return mapAnimals.get(name);
    }

    public void printAnimals() {
        for (String name : mapAnimals.keySet()) {
            System.out.println(name + " " + getAnimal(name));
        }
    }
}
