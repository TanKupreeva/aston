package org.example.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class CommandImpl implements Command{

    public boolean isExecute = true;

    public final BufferedReader bufferedReader;

    public final Map<Integer, Command> mapCommands = new HashMap<>();

    public CommandImpl(final BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    protected abstract void showMenu();

    @Override
    public void execute() {
        while (isExecute) {
            showMenu();
            try {
                Command commandImpl = mapCommands.get(Integer.parseInt(bufferedReader.readLine()));
                if (commandImpl != null) {
                    commandImpl.execute();
                } else System.out.println("Invalid choice. Try again.\n");

            } catch (NumberFormatException ex) {
                System.out.println("This handler only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        }
        isExecute = true;
    }

}
