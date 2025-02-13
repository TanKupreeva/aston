package org.example.entity.comparators.car.additional;

import org.example.entity.Car;

import java.util.Comparator;

public class Additional1ComparatorCar {

    private final Comparator<Car> comparator;

    public Additional1ComparatorCar() {
        comparator = new Additional1ComparatorCarPower();
//                .thenComparing(new Additional1ComparatorCarYear());
    }

    public Comparator<Car> getComparator() {
        return comparator;
    }

}
