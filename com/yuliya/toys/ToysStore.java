package com.yuliya.toys;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToysStore {
    private List<Toys> toys = new ArrayList<>();
    private Random random  = new Random();

    public void addToy(Toys toy) {
        if (!toys.isEmpty()) {
            Toys lastToy = toys.getLast();

            if (lastToy.getProbability() > toy.getProbability()) {
                throw new IllegalArgumentException("Toys are expected to be ordered by probability");
            }
        }

        toys.add(toy);
    }

    public List<Toys> getToys() {
        return toys; 
    }

    // public String getNextRandomToyName() {
    //     double r = random.nextDouble();

    //     for (Toys toys: toys) {

    //     }

    // }

    public static void main(String[] args) {
        ToysStore store = new ToysStore();
        
        // Создаем несколько игрушек и добавляем их в магазин
        store.addToy(new Toys(0, "Кукла", 6, 0.1));
        store.addToy(new Toys(1, "Медвежонок", 5, 0.3));
        store.addToy(new Toys(2, "Конструктор", 8, 0.6));
        
        // Выводим на консоль список всех игрушек в магазине
        System.out.println("Игрушки в магазине:");
        for (Toys toy: store.getToys()) {
            System.out.println(toy.getName());
        }
    }
}
