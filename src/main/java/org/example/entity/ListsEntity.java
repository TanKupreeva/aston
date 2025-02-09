package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class ListsEntity {
    private final static List<Book> books = new ArrayList<>();
    private final static List<Car> cars = new ArrayList<>();
    private final static List<RootVegetable> rootVegetables = new ArrayList<>();

    private ListsEntity() {}

    public static List<Book> getBooks() {
        return books;
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static List<RootVegetable> getRootVegetables() {
        return rootVegetables;
    }
}
