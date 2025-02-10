package org.example.filling;

import java.io.BufferedReader;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public abstract class Filler<T>{

    protected IntConsumer supplier;

    protected BufferedReader bufferedReader;

    protected List<T> originalList;

    public Filler(BufferedReader bufferedReader, List<T> originalList, IntConsumer supplier) {
        this.originalList = originalList;
        this.bufferedReader = bufferedReader;
        this.supplier = supplier;
    }


    abstract public void enterCapacity();

    protected void fill(int capacity) {
        IntStream.range(0, capacity).forEach(supplier);
        System.out.println("***************************************************************************************\n" +
                "Add " + capacity + " objects.\n" +
                "***************************************************************************************\n");
    }
}
