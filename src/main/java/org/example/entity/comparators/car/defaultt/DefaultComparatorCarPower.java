package org.example.entity.comparators.car.defaultt;

import org.example.entity.Car;

import java.util.Comparator;

import static org.example.entity.comparators.AllComparator.isBothOrSwitch;

public class DefaultComparatorCarPower implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getPower(), o2.getPower());
    }
}
