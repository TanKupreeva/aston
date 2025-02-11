package org.example.entity.comparators;

import java.util.Comparator;

public class AllComparator<T> {
    private final Comparator<T> comparator;

    public AllComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }
}
