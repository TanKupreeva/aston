package org.example.menu;

import org.example.entity.Book;
import org.example.entity.Car;
import org.example.entity.RootVegetable;
import org.example.menu.selectaction.SelectAction;
import org.example.menu.selectaction.SelectActionBook;
import org.example.menu.selectaction.SelectActionCar;
import org.example.menu.selectaction.SelectActionRootVegetable;
import org.example.utils.MyArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SelectClass extends CommandImpl {

    private final static List<Book> BOOKS = new MyArrayList<>();
    private final static List<Car> CARS = new MyArrayList<>();
    private final static List<RootVegetable> ROOT_VEGETABLES = new MyArrayList<>();

    private SelectClass(BufferedReader bufferedReader) {
        super(bufferedReader);
        builderMenu.append("\nPlease, select a collection class to operate on:\n");
        SelectAction<Book> bookSelectAction = new SelectActionBook(bufferedReader, BOOKS);
        SelectAction<Car> carSelectAction = new SelectActionCar(bufferedReader, CARS);
        SelectAction<RootVegetable> rootVegetableSelectAction = new SelectActionRootVegetable(bufferedReader, ROOT_VEGETABLES);

        mapCommands.put(1, bookSelectAction);
        builderMenu.append(1).append(" - Book.\n");

        mapCommands.put(2, carSelectAction);
        builderMenu.append(2).append(" - Car.\n");

        mapCommands.put(3, rootVegetableSelectAction);
        builderMenu.append(3).append(" - RootVegetable.\n");

        mapCommands.put(4, () -> {
            System.out.println("\nExit the program. Bye bye...");
            isExecute = false;
        });
        builderMenu.append(4).append(" - Exit the program.\n");
    }

    public static void start() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));) {
            CommandImpl mainCommand = new SelectClass(bufferedReader);
            mainCommand.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
