package org.example.menu.selectaction;

import org.example.entity.Car;
import org.example.entity.comparators.car.CarComparator;
import org.example.finder.FinderCar;
import org.example.menu.fillcollection.FillCollectionCar;

import java.io.BufferedReader;
import java.util.List;

public class SelectActionCar extends SelectAction<Car> {
    public SelectActionCar(BufferedReader bufferedReader, List<Car> list) {
        super(bufferedReader,
                Car.class,
                list,
                new FillCollectionCar(bufferedReader, list),
                new FinderCar(bufferedReader, list, new CarComparator().getComparator()),
                new CarComparator());
    }
}
