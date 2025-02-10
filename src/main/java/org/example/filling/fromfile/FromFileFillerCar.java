package org.example.filling.fromfile;

import org.example.entity.Car;
import org.example.utils.ReadFilesUtils;

import java.io.BufferedReader;
import java.util.List;

public class FromFileFillerCar extends FromFileFiller<Car> {
    public FromFileFillerCar(BufferedReader bufferedReader, List<Car> list) {
        super(bufferedReader, list);
        listFromFile = ReadFilesUtils.getCarsFromFile();
    }
}
