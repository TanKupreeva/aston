package org.example.filling.manual;

import org.example.entity.Car;
import org.example.soututils.GetValueCar;

import java.io.BufferedReader;
import java.util.List;

public class FillerManualCar extends FillerManual<Car> {

    public FillerManualCar(BufferedReader bufferedReader, List<Car> list) {
        super(bufferedReader,
                list,
                new GetValueCar(bufferedReader));
    }

}
