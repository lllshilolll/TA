package Aviary;

import animal.Animal;
import animal.Carnivorous;
import animal.Herbivore;

import java.util.HashMap;

public class Aviary<T extends Animal> {

    int count;
    private SizeAviary size;
    private final HashMap<String, T> mapAnimals;
    private String nameAnimal;


    public Aviary(SizeAviary sizeAviary) {
        count = 0;
        mapAnimals = new HashMap<>();
        this.size = sizeAviary;
    }


    public void addAnimal(T animal) {
        if (animal.getSize() <= size.getSize() && count < size.getMaxAnimalCount()) {
            if (mapAnimals.isEmpty()) {
                nameAnimal = animal.getName();
                mapAnimals.put(animal.getName(), animal);
                count++;
                return;
            }
            Animal an = mapAnimals.get(animal);
            if (an instanceof Herbivore && animal instanceof Herbivore) {
                mapAnimals.put(animal.getName(), animal);
                count++;
            } else if (an instanceof Carnivorous && animal instanceof Carnivorous) {
                mapAnimals.put(animal.getName(), animal);
                count++;
            } else System.out.println("Разные типы");
        } else {
            System.out.println("Вальер полный");
        }
    }

    public void deleteAnimal(String name) {
        mapAnimals.remove(name);
    }

    public void printAnimals() {
        for (String name : mapAnimals.keySet()) {
            System.out.println(name + " " + get(name));
        }
    }

    public Animal get(String name) {
        return mapAnimals.get(name);
    }
}
