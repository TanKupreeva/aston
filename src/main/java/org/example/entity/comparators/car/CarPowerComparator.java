package org.example.entity.comparators.car;

import org.example.entity.Car;

import java.util.Comparator;

import static org.example.entity.comparators.AllComparator.isBothOrSwitch;

public class CarPowerComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        boolean isEven1 = o1.getPower() % 2 == 0;
        boolean isEven2 = o2.getPower() % 2 == 0;
        int other = Integer.compare(o1.getPower(), o2.getPower());
        return isBothOrSwitch(isEven1, isEven2, other);
//        return Integer.compare(o1.getPower(), o2.getPower());
    }
}
