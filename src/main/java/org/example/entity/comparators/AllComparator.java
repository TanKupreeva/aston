package org.example.entity.comparators;

import java.util.Comparator;

public class AllComparator<T> {

    private final Comparator<T> comparatorDefault;

    private final Comparator<T> comparatorAdditional;

    public AllComparator(Comparator<T> comparatorDefault,
                         Comparator<T> comparatorAdditional) {
        this.comparatorDefault = comparatorDefault;
        this.comparatorAdditional = comparatorAdditional;
    }

    public final Comparator<T> getComparatorDefault() {
        return comparatorDefault;
    }

    public final Comparator<T> getComparatorAdditional() {
        return comparatorAdditional;
    }

    public static int isBothOrSwitch(boolean isEven1, boolean isEven2, int other) {
        if (!isEven1 && !isEven2) {
            return 0; // Оба нечетные → не менять порядок
        }
        if (!isEven1) {
            return -1; // o1 нечетное → оно должно остаться на месте
        }
        if (!isEven2) {
            return 1; // o2 нечетное → оно должно остаться на месте
        }
        return other;
    }

}
