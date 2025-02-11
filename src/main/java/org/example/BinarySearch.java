package org.example;

import java.util.Comparator;
import java.util.List;

public final class BinarySearch {

    private BinarySearch() {}

    public static <T> int search(List<T> list, T key, Comparator<T> comparator) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midVal = list.get(mid);

            if (midVal.equals(key)) {
                return mid; // key found
            }

            if (comparator.compare(midVal, key) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // key not found
    }
}
