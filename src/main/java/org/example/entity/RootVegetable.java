package org.example.entity;

public class RootVegetable {
    private final String type;
    private final double weight;
    private final String color;

    RootVegetable(String type, double weight, String color) {
        this.type = type;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "RootVegetable{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public static RootVegetableBuilder builder() {
        return new RootVegetableBuilder();
    }

    public String getType() {
        return this.type;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    public static class RootVegetableBuilder {
        private String type;
        private double weight;
        private String color;

        RootVegetableBuilder() {
        }

        public RootVegetableBuilder type(String type) {
            this.type = type;
            return this;
        }

        public RootVegetableBuilder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public RootVegetableBuilder color(String color) {
            this.color = color;
            return this;
        }

        public RootVegetable build() {
            return new RootVegetable(this.type, this.weight, this.color);
        }


    }

}