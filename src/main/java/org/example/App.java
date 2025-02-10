package org.example;

import org.example.entity.Book;
import org.example.entity.Car;
import org.example.entity.RootVegetable;
import org.example.menu.*;
import org.example.menu.selectaction.SelectAction;
import org.example.menu.selectaction.SelectActionBook;
import org.example.menu.selectaction.SelectActionCar;
import org.example.menu.selectaction.SelectActionRootVegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App extends CommandImpl
{
    private final static List<Book> books = new ArrayList<>();
    private final static List<Car> cars = new ArrayList<>();
    private final static List<RootVegetable> rootVegetables = new ArrayList<>();

    public App(BufferedReader bufferedReader) {
        super(bufferedReader);
        builderMenu.append("Please, select a collection class to operate on:\n");
        SelectAction<Book> bookSelectAction = new SelectActionBook(bufferedReader, books);
        SelectAction<Car> carSelectAction = new SelectActionCar(bufferedReader, cars);
        SelectAction<RootVegetable> rootVegetableSelectAction = new SelectActionRootVegetable(bufferedReader, rootVegetables);

        mapCommands.put(1, bookSelectAction);
        builderMenu.append(1).append(" - Book.\n");

        mapCommands.put(2, carSelectAction);
        builderMenu.append(2).append(" - Car.\n");

        mapCommands.put(3, rootVegetableSelectAction);
        builderMenu.append(3).append(" - RootVegetable.\n");

        mapCommands.put(4, () -> {
            System.out.println("\nExit the program. Bye bye...");
            isExecute = false;});
        builderMenu.append(4).append(" - Exit the program.\n");
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
        System.out.println("***************************************************************************************");

    }

}
