package org.example.menu.selectaction;

import org.example.entity.comparators.AllComparator;
import org.example.finder.Finder;
import org.example.menu.CommandImpl;
import org.example.menu.fillcollection.FillCollection;

import java.io.BufferedReader;
import java.util.List;

public class SelectAction<T> extends CommandImpl {

    protected List<T> list;

    public SelectAction(BufferedReader bufferedReader,
                        Class<T> tClass,
                        List<T> list,
                        FillCollection<T> filler,
                        Finder<T> finder,
                        AllComparator<T> comparator) {
        super(bufferedReader);
        this.list = list;
        builderMenu.append("\nPlease, select an action for ").append(tClass.getSimpleName()).append(" or exit:\n");

        mapCommands.put(1, filler);
        builderMenu.append(1).append(" - Fill collections.\n");

        mapCommands.put(2, ()-> {
            if (list.isEmpty()) System.out.print("ERROR. The list is empty\n" +
                    "First fill in the sheet, and then perform the search.\n");
            else finder.find();
        });
        builderMenu.append(2).append(" - Find an element of a sorted collection.\n");

        mapCommands.put(3, () -> System.out.println(list));
        builderMenu.append(3).append(" - Display collection items.\n");

        mapCommands.put(4, () -> list.sort(comparator.getComparator()));
        builderMenu.append(4).append(" - Sort collection items by all filed.\n");

        mapCommands.put(5, ()-> {
            System.out.println("Exit action selection. Return to main menu...");
            isExecute = false;
        });
        builderMenu.append(5).append(" - Exit action selection.\n");
    }
}

