package org.example.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandImpl implements Command{

    public boolean isExecute = true;

    protected final BufferedReader bufferedReader;

    protected final Map<Integer, Command> mapCommands = new HashMap<>();

    protected StringBuilder builderMenu = new StringBuilder();

    public CommandImpl(final BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    private void showMenu() {
        System.out.print(builderMenu);
    }

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
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        isExecute = true;
    }

}
