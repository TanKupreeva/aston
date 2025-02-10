package org.example.menu.fillcollection;

import org.example.entity.Car;
import org.example.filling.fromfile.FromFileFiller;
import org.example.filling.fromfile.FromFileFillerCar;
import org.example.filling.manual.ManualFiller;
import org.example.filling.manual.ManualFillerCar;
import org.example.filling.random.RandomFiller;
import org.example.filling.random.RandomFillerCar;

import java.io.BufferedReader;
import java.util.List;

public class FillCollectionCar extends FillCollection<Car> {
    public FillCollectionCar(BufferedReader bufferedReader, List<Car> list) {
//        FromFileFiller<Car> fromFileFiller = new FromFileFillerCar(list);
//        RandomFiller<Car> randomFiller = new RandomFillerCar(list);
//        ManualFiller<Car> manualFiller = new ManualFillerCar(list);
//        super(bufferedReader, fromFileFiller, randomFiller, manualFiller);

        super(bufferedReader, new FromFileFillerCar(bufferedReader, list), new RandomFillerCar(bufferedReader, list), new ManualFillerCar(bufferedReader, list));
    }
}
