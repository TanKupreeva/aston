package org.example;

import java.util.Comparator;

public class BinarySearch<T> {

    public static <T> int search(T[] array, T key, Comparator<T> comparator) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid].equals(key)) {
                return mid;
            }
            if (comparator.compare(array[mid], key) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
