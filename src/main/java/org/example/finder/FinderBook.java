package org.example.finder;

import org.example.entity.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FinderBook extends Finder<Book> {
    public FinderBook(BufferedReader bufferedReader, List<Book> originalList, Comparator<Book> comparator) {
        super(bufferedReader, originalList, comparator);
    }

    @Override
    protected Book getValue() {
        String author = "";
        String title = "";
        int pages = 0;
        boolean is = true;
        while (is) {
            try {
                System.out.println("Enter author:");
                author = bufferedReader.readLine();
                System.out.println("Enter title:");
                title = bufferedReader.readLine();
                System.out.println("Enter pages:");
                pages = Integer.parseInt(bufferedReader.readLine());
                is = false;
            } catch (NumberFormatException ex) {
                System.out.print("This field only accepts numbers.\n\n" +
                        "Try again.");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        Book book = Book.builder()
                .author(author)
                .title(title)
                .pages(pages)
                .build();
        return book;
    }

}
