package com.yuliya.toys;

public class Toys {

    private int id;
    private String name;
    private int number;
    private double probability;


    public Toys(int id, String name, int number, double probability) {
        this.id = id;
        this.name = name;
        setNumber(number); 
        setProbability(probability); 
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        this.number = number;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        if (probability < 0.0 || probability > 1.0) {
            throw new IllegalArgumentException("Probability must be between 0 and 1");
        }
        this.probability = probability;
    }

    public void decreaseNumber() {
        setNumber(this.number - 1);
    }
}
