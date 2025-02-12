package org.example.entity.comparators.car.defaultt;

import org.example.entity.Car;

import java.util.Comparator;

public class DefaultComparatorCarYear implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getYear(), o2.getYear());
    }
}
