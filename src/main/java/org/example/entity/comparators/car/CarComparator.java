package org.example.entity.comparators.car;

import org.example.entity.Car;
import org.example.entity.comparators.AllComparator;

public class CarComparator extends AllComparator<Car> {
    public CarComparator() {
        super(new CarModelComparator()
                .thenComparing(new CarPowerComparator())
                .thenComparing(new CarYearComparator()));
    }
}
