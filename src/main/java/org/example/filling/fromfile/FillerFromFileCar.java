package org.example.filling.fromfile;

import org.example.entity.Car;
import org.example.utils.ReadFilesUtils;

import java.io.BufferedReader;
import java.util.List;

public class FillerFromFileCar extends FillerFromFile<Car> {
    public FillerFromFileCar(BufferedReader bufferedReader, List<Car> list) {
        super(bufferedReader, list, ReadFilesUtils.getCarsFromFile());
    }
}
