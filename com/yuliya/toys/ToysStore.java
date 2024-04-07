package com.yuliya.toys;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

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
    
    public int getTotalToysNumber() {
        int counter = 0;

        for (Toys toy: toys) {
            counter += toy.getNumber();
        }

        return counter;
    }

    public Toys getNextRandomToyName() {
        double totalToysProbability = 0;
        for (Toys toy: toys) {
            totalToysProbability += toy.getProbability();
        }

        double r = random.nextDouble() * totalToysProbability;
        double cumulativeProbability = 0;
        
        Toys selectedToys = null;
        for (Toys toy: toys) {
            cumulativeProbability += toy.getProbability();

            if (r <= cumulativeProbability) {
                selectedToys = toy;
                break;
            }
        }
        
        if (selectedToys != null) {
            selectedToys.decreaseNumber();

            if (selectedToys.getNumber() == 0) {
                toys.remove(selectedToys);
            }
        }

        return selectedToys;
    }

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("result.txt");
        ToysStore store = new ToysStore();
        
        store.addToy(new Toys(0, "Кукла", 3, 0.2));
        store.addToy(new Toys(1, "Медвежонок", 4, 0.3));
        store.addToy(new Toys(2, "Конструктор", 5, 0.5));
        
        System.out.println("Розыгрыш игрушек:");
        while (true) {
            Toys toy = store.getNextRandomToyName();

            if (toy == null) {
                System.out.println("Игрушки закончились!");
                break;
            }
            
            System.out.println(toy.getName());
            System.out.println(store.getTotalToysNumber());

            writer.write(toy.getName() + "\n");
        }

        writer.flush();
        writer.close();
    }
}
