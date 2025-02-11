package org.example.finder;

import org.example.utils.soututils.GetValue;
import org.example.utils.BinarySearch;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.List;

public class Finder<T> {

    protected final BufferedReader bufferedReader;

    protected final List<T> originalList;

    private final Comparator<T> comparator;

    private final GetValue<T> function;

    public Finder(BufferedReader bufferedReader,
                  List<T> originalList,
                  GetValue<T>  function,
                  Comparator<T> comparator) {
        this.bufferedReader = bufferedReader;
        this.originalList = originalList;
        this.comparator = comparator;
        this.function = function;
    }

    public void find() {
        System.out.print("\nFill in the fields to search the collection:\n");
        int i = -1;
        T key = function.getFunction().apply(i);
        originalList.sort(comparator);
        int index = BinarySearch.search(originalList, key, comparator);

        if (index != -1) {
            System.out.print("***************************************************************************************\n" +
                    "Element found!\n" +
                    "Element=" + originalList.get(index) + "\n" +
                    "***************************************************************************************\n");
        } else System.out.print("***************************************************************************************\n" +
                "Element not found! Try again...\n"+
                "***************************************************************************************\n");
    }

}
