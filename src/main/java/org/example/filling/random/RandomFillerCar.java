package org.example.filling.random;

import org.example.entity.Car;
import org.example.utils.ReadFilesUtils;

import java.io.BufferedReader;
import java.util.List;

public class RandomFillerCar extends RandomFiller<Car> {
    public RandomFillerCar(BufferedReader bufferedReader, List<Car> list) {
        super(bufferedReader, list);
        listRandom = ReadFilesUtils.getCarsFromFile();
    }

}
