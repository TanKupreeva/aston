package org.example.menu.selectaction;

import org.example.entity.Car;
import org.example.menu.findcollection.FindCollection;
import org.example.menu.fillcollection.FillCollectionCar;
import org.example.menu.fillcollection.FillCollection;
import org.example.menu.findcollection.FindCollectionCar;

import java.io.BufferedReader;
import java.util.List;

public class SelectActionCar extends SelectAction<Car> {
    public SelectActionCar(BufferedReader bufferedReader, List<Car> list) {
//        FillCollection<Car> filler = new FillCollectionCar(bufferedReader, list);
//        FindCollection<Car> finder = new FindCollectionCar(bufferedReader, list));
//        super(bufferedReader, filler, finder);

        super(bufferedReader, new FillCollectionCar(bufferedReader, list), new FindCollectionCar(bufferedReader, list));
        this.list = list;    }
}
