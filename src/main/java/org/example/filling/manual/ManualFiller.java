package org.example.filling.manual;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.util.List;

public abstract class ManualFiller<T> extends Filler<T> {

    public ManualFiller(BufferedReader bufferedReader, List<T> list) {
        super(bufferedReader, list);
    }

    @Override
    protected abstract T getValue();

}
