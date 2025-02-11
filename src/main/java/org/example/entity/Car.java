package org.example.entity;

public class Car {
    private final int power;
    private final String model;
    private final int year;

    Car(int power, String model, int year) {
        this.power = power;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public int getPower() {
        return this.power;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public static class CarBuilder {
        private int power;
        private String model;
        private int year;

        CarBuilder() {
        }

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
            return new Car(this.power, this.model, this.year);
        }

        public String toString() {
            return "Car.CarBuilder(power=" + this.power + ", model=" + this.model + ", year=" + this.year + ")";
        }
    }
}