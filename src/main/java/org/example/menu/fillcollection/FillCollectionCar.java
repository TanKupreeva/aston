package org.example.menu.fillcollection;

import org.example.entity.Car;
import org.example.filling.fromfile.FillerFromFileCar;
import org.example.filling.manual.FillerManualCar;
import org.example.filling.random.FillerRandomCar;

import java.io.BufferedReader;
import java.util.List;

public class FillCollectionCar extends FillCollection<Car> {
    public FillCollectionCar(BufferedReader bufferedReader, List<Car> list) {
        super(bufferedReader, Car.class,
                new FillerFromFileCar(bufferedReader, list),
                new FillerRandomCar(bufferedReader, list),
                new FillerManualCar(bufferedReader, list));
    }
}
