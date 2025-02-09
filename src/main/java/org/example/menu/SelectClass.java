package org.example.menu;

import org.example.entity.ListsEntity;

import java.io.BufferedReader;

public class SelectClass extends CommandImpl {

    public SelectClass(BufferedReader bufferedReader, BeforeCommand command) {
            super(bufferedReader);
            mapCommands.put(1, () -> {
                System.out.println("\nAuto");
                command.beforeExecute(ListsEntity.getCars());
            });
            mapCommands.put(2, () -> {
                System.out.println("\nBook");
                command.beforeExecute(ListsEntity.getBooks());
            });
            mapCommands.put(3, () -> {
                System.out.println("\nRootVegetable");
                command.beforeExecute(ListsEntity.getRootVegetables());
            });
            mapCommands.put(4, ()-> {
                System.out.println("\nExit filling.");
                isExecute = false;
            });
        }

    @Override
    public void showMenu() {
        System.out.print("Please select the class you want to fill:\n" +
                "1 - Auto\n" +
                "2 - Book\n" +
                "3 - RootVegetable\n" +
                "4 - Exit selection\n");
    }

}

