package org.example.utils;

import java.util.Comparator;
import java.util.List;

public final class BinarySearch<T> {

    private BinarySearch() {}

    public static <T> int search(List<T> list, T key, Comparator<T> comparator) {
        int left = 0;
        int right = list.size()-1;

        while (left <= right ) {
            int mid = (left + right ) >>> 1;
            T midVal = list.get(mid);
            int cmp = comparator.compare(midVal, key);

            if (cmp < 0)
                left = mid + 1;
            else if (cmp > 0)
                right  = mid - 1;
            else
                return mid; // key found
        }
        return -1;  // key not found
    }

}
