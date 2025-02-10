package org.example.menu.selectaction;

import org.example.menu.CommandImpl;
import org.example.menu.findcollection.FindCollection;
import org.example.menu.fillcollection.FillCollection;

import java.io.BufferedReader;
import java.util.List;

public class SelectAction<T> extends CommandImpl {

    protected List<T> list;

    public SelectAction(BufferedReader bufferedReader, Class<T> tClass,
                        FillCollection<T> filler,
                        FindCollection<T> finder) {
        super(bufferedReader);
        builderMenu.append("Please, select an action for ").append(tClass.getSimpleName()).append(" or exit:\n");

        mapCommands.put(1, filler);
        builderMenu.append(1).append(" - Fill collections.\n");

        mapCommands.put(2, finder);
        builderMenu.append(2).append(" - Find an element of a sorted collection.\n");

        mapCommands.put(3, () -> System.out.println(list));
        builderMenu.append(3).append(" - Sout all elements collection.\n");

        mapCommands.put(4, ()-> {
            System.out.println("\nExit action selection. Return to main menu...");
            isExecute = false;
        });
        builderMenu.append(4).append(" - Exit action selection.\n");
    }
}

