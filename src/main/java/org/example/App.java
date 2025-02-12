package org.example;

import org.example.menu.SelectClass;

public class App
{

    public static void main( String[] args ) {
        System.out.print("***************************************************************************************\n" +
                "Hello!\n" +
                "This is an application that will implement the sorting algorithm for the passed classes\n" +
                "***************************************************************************************\n");

        SelectClass.start();

        System.out.print("\n***************************************************************************************\n" +
                "Exit the program. Bye bye..." +
                "\n***************************************************************************************\n");
    }

}
