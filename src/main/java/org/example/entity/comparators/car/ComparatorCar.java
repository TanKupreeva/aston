package org.example.entity.comparators.car;

import org.example.entity.Car;
import org.example.entity.comparators.AllComparator;
import org.example.entity.comparators.car.additional.Additional1ComparatorCar;
import org.example.entity.comparators.car.defaultt.DefaultComparatorCar;

public class ComparatorCar extends AllComparator<Car> {
    public ComparatorCar() {
        super(new DefaultComparatorCar().getComparator(), new
                Additional1ComparatorCar().getComparator());
    }
}
