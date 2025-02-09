package org.example.filling.manual;

import org.example.filling.FillerStrategy;

import java.util.List;

public abstract class ManualFillerStrategy<T> extends FillerStrategy<T> {

    public ManualFillerStrategy(List<T> list) {
        super(list);
    }

    @Override
    protected T getValue() {
        return getV();
    }

    protected abstract T getV();
}
