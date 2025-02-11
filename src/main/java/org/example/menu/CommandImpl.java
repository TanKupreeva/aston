package org.example.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandImpl implements Command{

    protected boolean isExecute = true;

    protected final BufferedReader bufferedReader;

    protected final Map<Integer, Command> mapCommands = new HashMap<>();

    protected final StringBuilder builderMenu = new StringBuilder();

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
                int i = Integer.parseInt(bufferedReader.readLine());
                Command commandImpl = mapCommands.get(i);
                if (commandImpl != null) {
                    commandImpl.execute();
                } else System.out.println("Invalid choice. Try again.\n");

            } catch (NumberFormatException ex) {
                System.out.print("This handler only accepts numbers. Try again.\n");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        isExecute = true;
    }

}
