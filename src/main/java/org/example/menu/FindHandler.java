package org.example.menu;

import java.io.BufferedReader;

public class FindHandler extends CommandImpl {

    public FindHandler(BufferedReader bufferedReader) {
        super(bufferedReader);
        mapCommands.put(1, () -> {
            System.out.println("\nAuto");
        });
        mapCommands.put(2, () -> {
            System.out.println("\nBook");
        });
        mapCommands.put(3, () -> {
            System.out.println("\nRootVegetable");
        });
        mapCommands.put(4, ()-> {
            System.out.println("\nExit filling.");
            isExecute = false;
        });
    }

    @Override
     public void showMenu() {
        System.out.print("Please select the class of which object you want to find:\n" +
                "1 - Auto\n" +
                "2 - Book\n" +
                "3 - RootVegetable\n" +
                "4 - Exit finding\n");
    }

}
