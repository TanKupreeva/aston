package org.example.menu.findcollection;

import org.example.menu.CommandImpl;

import java.io.BufferedReader;
import java.util.List;

public class FindCollection<T> extends CommandImpl {

    public FindCollection(BufferedReader bufferedReader, Class<T> tClass,
                          List<T> list) {
        super(bufferedReader);
        builderMenu.append("Please, select the field by which you want to find the object ").append(tClass.getSimpleName()).append(":\n");
        mapCommands.put(1,()-> {
//            fromFileFiller.fill();
        });
//        builderMenu.append(1).append(" - From file.\n");

        mapCommands.put(2, ()-> {
            System.out.println("\nExit finding. Return to select action...");
            isExecute = false;
        });
        builderMenu.append(2).append(" - Exit finding selection.\n");
    }

}
