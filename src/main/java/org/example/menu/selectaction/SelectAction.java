package org.example.menu.selectaction;

import org.example.finder.Finder;
import org.example.menu.Command;
import org.example.menu.CommandImpl;
import org.example.menu.SelectSort;
import org.example.menu.fillcollection.FillCollection;

import java.io.BufferedReader;
import java.util.List;
import java.util.function.Consumer;

public class SelectAction<T> extends CommandImpl {

    protected List<T> list;

    protected final String nameCollection;

    Consumer<Command> collectionIsEmpty = (i) -> {
        if (list.isEmpty())
            System.out.print("ERROR. THE LIST IS EMPTY\n" +
                    "First fill out the list, then search.\n");
        else i.execute();
    };

    public SelectAction(BufferedReader bufferedReader,
                        Class<T> tClass,
                        List<T> list,
                        FillCollection<T> filler,
                        Finder<T> finder,
                        SelectSort<T> sort) {
        super(bufferedReader);
        this.list = list;
        this.nameCollection = tClass.getSimpleName();
        builderMenu.append("\nPlease, select an action for ").append(nameCollection).append(" or exit:\n");

        mapCommands.put(1, filler);
        builderMenu.append(1).append(" - Fill collections.\n");

        mapCommands.put(2, ()-> collectionIsEmpty.accept(finder::find));
        builderMenu.append(2).append(" - Find an element of a sorted collection.\n");

        mapCommands.put(3, () -> collectionIsEmpty.accept(() -> {
            System.out.print("***************************************************************************************\n");
            System.out.print(list.size() + " elements:\n");
            list.forEach(System.out::println);
            System.out.print("***************************************************************************************\n");
        }));
        builderMenu.append(3).append(" - Display collection items.\n");

        mapCommands.put(4, () -> collectionIsEmpty.accept(sort));
        builderMenu.append(4).append(" - Sort collection items by all filed.\n");

        mapCommands.put(5, ()-> {
            System.out.print("Exit action selection. Return to main menu...\n");
            isExecute = false;
        });
        builderMenu.append(5).append(" - Exit action selection.\n");
    }
}

