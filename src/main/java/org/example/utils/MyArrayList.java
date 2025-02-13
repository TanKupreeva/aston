package org.example.utils;

import java.util.AbstractList;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<T> extends AbstractList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private final Sorter<T> sorter = new Sorter<>(this);

    Object[] elementData;

    private int size = 0;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        Objects.checkIndex(initialCapacity, (long) Integer.MAX_VALUE+1);
        elementData = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    @Override
    public T set(int index, T element) {
        Objects.checkIndex(index, size);
        T oldValue = (T) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public void sort(Comparator<? super T> c) {
        sorter.mergeSort(c);
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);

        T oldValue = (T) elementData[index];
        int newSize= size - 1;
        if (newSize > index) System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        size = newSize;
        elementData[size] = null;

        return oldValue;
    }

    @Override
    public boolean add(T t) {
        if (size < elementData.length) {
            elementData[size++] = t;
            return true;
        } else return grow(t);
    }

    private boolean grow(T t) {
        if (size < DEFAULT_CAPACITY) {
            return grow(t, DEFAULT_CAPACITY);
        } else if ((elementData.length * 2)  < Integer.MAX_VALUE) {
            return grow(t, elementData.length * 2 );
        } else if (size < Integer.MAX_VALUE) {
            return grow(t, Integer.MAX_VALUE );
        } else {
            System.out.println("ERROR: size < Integer.MAX_VALUE");
            return false;
        }
    }

    private boolean grow(T t, int capacity) {
        Object[] newElementData = new Object[capacity];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
        elementData[size++] = t;
        return true;
    }

}
