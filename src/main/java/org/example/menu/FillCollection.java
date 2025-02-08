package org.example.menu;

import java.io.BufferedReader;

public class FillCollection extends CommandImpl {

    public FillCollection(BufferedReader bufferedReader) {
        super(bufferedReader);
        mapCommands.put(1, () -> {
            System.out.println("\nFrom file:");
        });
        mapCommands.put(2, () -> {
            System.out.println("\nRandom values:");
        });
        mapCommands.put(3, () -> {
            System.out.println("\nManual filling:");
        });
        mapCommands.put(4, ()-> {
            System.out.println("\nExit filling.");
            isExecute = false;
        });
    }

    @Override
    public void showMenu() {
        System.out.print("Please select the filling type or exit:\n" +
                "1 - From file\n" +
                "2 - Random values\n" +
                "3 - Manual filling\n" +
                "4 - Exit filling\n");
    }

}
