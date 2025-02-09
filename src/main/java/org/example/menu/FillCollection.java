package org.example.menu;

import org.example.filling.FillerStrategy;
import org.example.filling.fromfile.FromFileFillerStrategy;
import org.example.filling.random.RandomFillerStrategy;

import java.io.BufferedReader;
import java.util.List;

public class FillCollection<T> extends CommandImpl implements BeforeCommand<T> {

    List<T> list;

    public FillCollection(BufferedReader bufferedReader) {
        super(bufferedReader);
        FillerStrategy<T> fillerStrategy1 = new FromFileFillerStrategy<>(list);
        FillerStrategy<T> fillerStrategy2 = new RandomFillerStrategy<>(list);

//        Filler<T> filler3 = new BookManualFiller(list);
        mapCommands.put(1, () -> {
            System.out.println("\nFrom file:");
            fillerStrategy1.fill();
        });
        mapCommands.put(2, () -> {
            System.out.println("\nRandom values:");
            fillerStrategy2.fill();
        });
        mapCommands.put(3, () -> {
            System.out.println("\nManual filling:");
//            filler3.fill();
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

    @Override
    public void beforeExecute(List<T> list)  {
        this.list = list;
        this.execute();
    }
}
