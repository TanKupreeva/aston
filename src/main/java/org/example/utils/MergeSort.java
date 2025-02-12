package org.example.utils;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public final class MergeSort<T> {

    private final List<T> list;

    public MergeSort(List<T> list) {
        this.list = list;
    }

    public void sort(Comparator<? super T> comparator) {
        Object[] dest = list.toArray();
        Object[] src = dest.clone();
        mergeSort(src, dest, 0, dest.length, 0, comparator);

        ListIterator<T> i = list.listIterator();
        for (Object e : dest) {
            i.next();
            i.set((T) e);
        }
    }

    private static void mergeSort(Object[] src,
                                  Object[] dest,
                                  int low, int high, int off,
                                  Comparator comparator) {
        int length = high - low;

        // Insertion sort on smallest arrays
        if (length < 7) {
            for (int i = low; i < high; i++)
                for (int j = i; j > low && comparator.compare(dest[j - 1], dest[j]) > 0; j--)
                    swap(dest, j, j - 1);
            return;
        }

        // Recursively sort halves of dest into src
        int destLow = low;
        int destHigh = high;
        low += off;
        high += off;
        int mid = (low + high) >>> 1;
        mergeSort(dest, src, low, mid, -off, comparator);
        mergeSort(dest, src, mid, high, -off, comparator);

        // If list is already sorted, just copy from src to dest.  This is an
        // optimization that results in faster sorts for nearly ordered lists.
        if (comparator.compare(src[mid - 1], src[mid]) <= 0) {
            System.arraycopy(src, low, dest, destLow, length);
            return;
        }

        // Merge sorted halves (now in src) into dest
        for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if (q >= high || p < mid && comparator.compare(src[p], src[q]) <= 0)
                dest[i] = src[p++];
            else
                dest[i] = src[q++];
        }
    }

    private static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

}
