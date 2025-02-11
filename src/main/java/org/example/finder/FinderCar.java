package org.example.finder;

import org.example.entity.Car;
import org.example.utils.soututils.GetValueCar;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.List;

public class FinderCar extends Finder<Car> {
    public FinderCar(BufferedReader bufferedReader, List<Car> originalList, Comparator<Car> comparator) {
        super(bufferedReader,
                originalList,
                new GetValueCar(bufferedReader),
                comparator);
    }

}