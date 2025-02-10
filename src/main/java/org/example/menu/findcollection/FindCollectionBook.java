package org.example.menu.findcollection;

import org.example.entity.Book;

import java.io.BufferedReader;
import java.util.List;

public class FindCollectionBook extends FindCollection<Book> {
    public FindCollectionBook(BufferedReader bufferedReader, List<Book> list) {
        super(bufferedReader, list);
//        FromFileFiller<Car> fromFileFiller = new FromFileFillerCar(list);
//        RandomFiller<Car> randomFiller = new RandomFillerCar(list);
//        ManualFiller<Car> manualFiller = new ManualFillerCar(list);
//        super(bufferedReader, fromFileFiller, randomFiller, manualFiller);

//        super(bufferedReader, new FromFileFillerCar(list), new RandomFillerCar(list), new ManualFillerCar(list));
    }
}
