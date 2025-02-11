package org.example.menu.fillcollection;

import org.example.filling.fromfile.FillerFromFile;
import org.example.filling.manual.FillerManual;
import org.example.filling.random.FillerRandom;
import org.example.menu.CommandImpl;

import java.io.BufferedReader;

public class FillCollection<T> extends CommandImpl {

    public FillCollection(BufferedReader bufferedReader, Class<T> tClass,
                          FillerFromFile<T> fillerFromFile,
                          FillerRandom<T> fillerRandom,
                          FillerManual<T> fillerManual) {
        super(bufferedReader);
        builderMenu.append("\nPlease select the fill type for ").append(tClass.getSimpleName()).append(" or exit:\n");

        mapCommands.put(1, fillerFromFile::enterCapacity);
        builderMenu.append(1).append(" - From file.\n");

        mapCommands.put(2, fillerRandom::enterCapacity);
        builderMenu.append(2).append(" - Random values.\n");

        mapCommands.put(3, fillerManual::enterCapacity);
        builderMenu.append(3).append(" - Manual.\n");

        mapCommands.put(4, ()-> {
            System.out.println("Exit filling. Return to select action...");
            isExecute = false;
        });
        builderMenu.append(4).append(" - Exit filling selection.\n");
    }

}
