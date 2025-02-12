package org.example.menu;

import java.io.BufferedReader;
import java.util.List;

public class SaveElements<T> extends CommandImpl{
    public SaveElements(BufferedReader bufferedReader, List<T> listForSave) {
        super(bufferedReader);
        builderMenu.append("\nSave to file?\n");
        mapCommands.put(1, () -> {
            // TO DO saving
            System.out.print("Data saved in file!\n");
            isExecute = false;
        });
        builderMenu.append(1).append(" - Yes.\n");

        mapCommands.put(2, () ->{
            System.out.print("Data not saved\n");
            System.out.print("Exit the save menu\n");
            isExecute = false;
        });
        builderMenu.append(2).append(" - No.\n");

    }
}
