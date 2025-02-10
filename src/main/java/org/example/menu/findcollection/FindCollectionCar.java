package org.example.menu.findcollection;

import org.example.entity.Car;

import java.io.BufferedReader;
import java.util.List;

public class FindCollectionCar extends FindCollection<Car> {
    public FindCollectionCar(BufferedReader bufferedReader, List<Car> list) {
        super(bufferedReader, Car.class,
                list);
    }
}
