package org.example.entity.comparators.car.defaultt;

import org.example.entity.Car;

import java.util.Comparator;

public class DefaultComparatorCarModel implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getModel().compareToIgnoreCase(o2.getModel());
    }
}