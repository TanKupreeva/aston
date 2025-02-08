package org.example;

import org.example.menu.CommandImpl;
import org.example.menu.FillCollection;
import org.example.menu.FindHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App extends CommandImpl
{
    public App(BufferedReader bufferedReader) {
        super(bufferedReader);
        mapCommands.put(1, new FillCollection(bufferedReader));
        mapCommands.put(2, new FindHandler(bufferedReader));
        mapCommands.put(3, () -> {
            System.out.println("\nExit the program. Bye bye...");;
            isExecute = false;});
    }

    @Override
    public void showMenu() {
        System.out.print("Please, select an action:\n" +
                "1 - Fill collections\n" +
                "2 - Find an element of a sorted collection\n" +
                "3 - Exit the program\n");
    }

    public static void main( String[] args ) {
        System.out.print("***************************************************************************************\n" +
                "Hello!\n" +
                "This is an application that will implement the sorting algorithm for the passed classes\n" +
                "***************************************************************************************\n");

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));) {
            CommandImpl mainCommand = new App(bufferedReader);
            mainCommand.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n***************************************************************************************\n");

    }

}
