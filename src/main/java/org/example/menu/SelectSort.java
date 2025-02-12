package org.example.menu;

import org.example.entity.comparators.AllComparator;

import java.io.BufferedReader;
import java.util.List;

public class SelectSort<T> extends CommandImpl {

    protected final List<T> list;

    protected final String nameCollection;

    public SelectSort(BufferedReader bufferedReader,
                      Class<T> tClass,
                      List<T> list,
                      AllComparator<T> comparator) {
        super(bufferedReader);
        this.list = list;
        this.nameCollection = tClass.getSimpleName();

        SaveElements<T> saveElements = new SaveElements<>(bufferedReader, list);

        builderMenu.append("\nPlease select a sorting method").append(" or exit:\n");

        mapCommands.put(1, () -> {
            list.sort(comparator.getComparatorDefault());
            System.out.print("***************************************************************************************\n" +
                    "The " + nameCollection + " Collection is sorted! Sorter default.\n" +
                    "***************************************************************************************\n");
            saveElements.execute();
                });
        builderMenu.append(1).append(" - Default sorting.\n");

        mapCommands.put(2, () -> {
            list.sort(comparator.getComparatorAdditional());
            System.out.print("***************************************************************************************\n" +
                    "The " + nameCollection + " Collection is sorted! Sorter additional.\n" +
                    "***************************************************************************************\n");
            saveElements.execute();
        });
        builderMenu.append(2).append(" - Additional sorting.\n");

        mapCommands.put(3, ()-> {
            System.out.print("Exit sort selection. Return to select action...\n");
            isExecute = false;
        });
        builderMenu.append(3).append(" - Exit action selection.\n");
    }
}
