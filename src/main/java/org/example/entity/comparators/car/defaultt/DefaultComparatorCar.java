package org.example.entity.comparators.car.defaultt;

import org.example.entity.Car;

import java.util.Comparator;

public class DefaultComparatorCar {

    private final Comparator<Car> comparator;

    public DefaultComparatorCar() {
        comparator = new DefaultComparatorCarPower()
                .thenComparing(new DefaultComparatorCarModel())
                .thenComparing(new DefaultComparatorCarYear());
    }

    public Comparator<Car> getComparator() {
        return comparator;
    }
}
