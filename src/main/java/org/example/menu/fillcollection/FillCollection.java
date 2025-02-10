package org.example.menu.fillcollection;

import org.example.filling.fromfile.FromFileFiller;
import org.example.filling.manual.ManualFiller;
import org.example.filling.random.RandomFiller;
import org.example.menu.CommandImpl;

import java.io.BufferedReader;

public class FillCollection<T> extends CommandImpl {

    public FillCollection(BufferedReader bufferedReader, Class<T> tClass,
                          FromFileFiller<T> fromFileFiller,
                          RandomFiller<T> randomFiller,
                          ManualFiller<T> manualFiller) {
        super(bufferedReader);
        builderMenu.append("Please select the fill type for ").append(tClass.getSimpleName()).append(" or exit:\n");
        mapCommands.put(1,()-> {
            fromFileFiller.enterCapacity();
        });
        builderMenu.append(1).append(" - From file.\n");
        mapCommands.put(2, () -> {
            randomFiller.enterCapacity();
        });
        builderMenu.append(2).append(" - Random values.\n");
        mapCommands.put(3, () -> {
            manualFiller.enterCapacity();
        });
        builderMenu.append(3).append(" - Manual.\n");
        mapCommands.put(4, ()-> {
            System.out.println("\nExit filling. Return to select action...");
            isExecute = false;
        });
        builderMenu.append(4).append(" - Exit filling selection.\n");
    }

}
