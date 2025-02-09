package org.example.random;

import java.util.Objects;

public class RootVegetable extends Prog{
    private  String type;
    private  double weight;
    private  String color;

    @Override
    public String toString() {
        return "RootVegetable{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RootVegetable that = (RootVegetable) o;
        return Double.compare(weight, that.weight) == 0 && Objects.equals(type, that.type) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, color);
    }

    private RootVegetable(RootVegetableBuilder rootVegetableBuilder) {
        this.type = rootVegetableBuilder.type;
        this.weight = rootVegetableBuilder.weight;
        this.color = rootVegetableBuilder.color;
    }
    public RootVegetable() {
        this.fillTheArray = new FillClassRootVegetable();
    }
    public String getType() {
        return type;
    }
    public double getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }

    public static class RootVegetableBuilder {
        private String type;
        private double weight;
        private String color;

        public RootVegetableBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public RootVegetableBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public RootVegetableBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootVegetableBuilder(String type, double weight, String color) {
            this.type = type;
            this.weight = weight;
            this.color = color;
        }

        public RootVegetable build() {
            return new RootVegetable(this);
        }
    }
}
