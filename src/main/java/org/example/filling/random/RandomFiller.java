package org.example.filling.random;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.util.List;

public class RandomFiller<T> extends Filler<T> {

    protected List<T> listRandom;

    public RandomFiller(BufferedReader bufferedReader, List<T> list) {
        super(bufferedReader, list);
    }

    @Override
    protected T getValue() {
        int to = listRandom.size() - 1;
        int random_number = (int) (Math.random() * to);
        return listRandom.get(random_number);
    }
}
