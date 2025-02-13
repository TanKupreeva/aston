package org.example.menu;

import org.example.entity.comparators.AllComparator;
import org.example.utils.Sorter;

import java.io.BufferedReader;
import java.util.List;
import java.util.function.Predicate;

public class SelectSort<T> extends CommandImpl {

    protected final List<T> list;

    private final String nameCollection;

    public String getNameCollection() {
        return nameCollection;
    }

    private final StringBuilder sorted = new StringBuilder()
            .append("***************************************************************************************\n")
            .append("The ").append(getNameCollection()).append(" Collection is sorted!\n")
            .append("***************************************************************************************\n");

    public SelectSort(BufferedReader bufferedReader,
                      List<T> list,
                      Class<T> tClass,
                      AllComparator<T> comparator,
                      Predicate<T> predicate) {
        super(bufferedReader);
        this.list = list;
        this.nameCollection = tClass.getSimpleName();

        Sorter<T> sorter = new Sorter<>(list);

        SaveElements<T> saveElements = new SaveElements<>(bufferedReader, list);

        builderMenu.append("\nPlease select a sorting method").append(" or exit:\n");

        mapCommands.put(1, () -> {
            list.sort(comparator.getComparatorDefault());
            System.out.print(sorted);
            saveElements.execute();
                });
        builderMenu.append(1).append(" - Default sorting.\n");

        mapCommands.put(2, () -> {
            sorter.additionalSort(comparator.getComparatorAdditional(), predicate);
            System.out.print(sorted);
            saveElements.execute();
        });
        builderMenu.append(2).append(" - Additional sorting.\n");

//        mapCommands.put(3, () -> {
//            list.sort(comparator.getComparatorAdditional());
//            System.out.print(sorted);
//            saveElements.execute();
//        });
//        builderMenu.append(3).append(" - Additional sorting. Simple option.\n");

        mapCommands.put(3, ()-> {
            System.out.print("Exit sort selection. Return to select action...\n");
            isExecute = false;
        });
        builderMenu.append(3).append(" - Exit action selection.\n");
    }
}
