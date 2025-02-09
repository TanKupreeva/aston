package org.example.entity;

public class Car {
    private final int power;
    private final String model;
    private final int year;

    private Car(CarBuilder carBuilder) {
        this.power = carBuilder.power;
        this.model = carBuilder.model;
        this.year = carBuilder.year;
    }

    public int getPower() { return power; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    public static class CarBuilder {
        private int power;
        private String model;
        private int year;

        public CarBuilder power(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder year(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}