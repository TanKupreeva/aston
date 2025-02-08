package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main( String[] args ) {
        System.out.print("***************************************************************************************\n" +
                "Hello!\n" +
                "This is an application that will implement the sorting algorithm for the passed classes\n" +
                "***************************************************************************************\n");
        boolean mainHandlerIsWork = true;
        do {
            System.out.print("Please, select an action:\n" +
                    "1 - Fill collections\n" +
                    "2 - Find an element of a sorted collection\n" +
                    "3 - Exit the program\n");

            try {
                switch (Integer.parseInt(bufferedReader.readLine())) {
                    case 1:{
                        System.out.println("\nFill collections:");
                        fillHandler();
                        break;
                    }
                    case 2:{
                        System.out.println("\nFind an element of a sorted collection:");
                        findHandler();
                        break;
                    }
                    case 3: {
                        System.out.println("\nExit the program. Bye bye...");
                        mainHandlerIsWork = false;
                        break;
                    }
                    default: System.out.println("Invalid choice. Try again.\n");
                }
            } catch (NumberFormatException ex) {
                System.out.println("This handler only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        } while (mainHandlerIsWork);

        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void fillHandler() {
        boolean fillHandlerIsWork = true;
        do {
            System.out.print("Please select the filling type or exit:\n" +
                    "1 - From file\n" +
                    "2 - Random values\n" +
                    "3 - Manual filling\n" +
                    "4 - Exit filling\n");

            try {
                switch (Integer.parseInt(bufferedReader.readLine())) {
                    case 1:{
                        System.out.println("\nFrom file:");

                        break;
                    }
                    case 2:{
                        System.out.println("\nRandom values:");

                        break;
                    }
                    case 3:{
                        System.out.println("\nManual filling:");

                        break;
                    }
                    case 4: {
                        System.out.println("\nExit filling.");
                        fillHandlerIsWork = false;
                        break;
                    }
                    default: System.out.println("Invalid choice. Try again.\n");
                }
            } catch (NumberFormatException ex) {
                System.out.println("This handler only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        } while (fillHandlerIsWork);
    }

    private static void findHandler() {
        System.out.println("Classes: ..."); // дописать какие есть у нас классы и функционал по поиску
        boolean findHandlerIsWork = true;
        do {
            System.out.print("Please select the class of which object you want to find:\n" +
                    "1 - Auto\n" +
                    "2 - Book\n" +
                    "3 - RootVegetable\n" +
                    "4 - Exit finding\n");

            try {
                switch (Integer.parseInt(bufferedReader.readLine())) {
                    case 1:{
                        System.out.println("\nAuto");

                        break;
                    }
                    case 2:{
                        System.out.println("\nBook");

                        break;
                    }
                    case 3:{
                        System.out.println("\nRootVegetable");

                        break;
                    }
                    case 4: {
                        System.out.println("\nExit filling.");
                        findHandlerIsWork = false;
                        break;
                    }
                    default: System.out.println("Invalid choice. Try again.\n");
                }
            } catch (NumberFormatException ex) {
                System.out.println("This handler only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        } while (findHandlerIsWork);

    }
}
