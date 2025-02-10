package org.example.filling.manual;

import org.example.entity.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ManualFillerBook extends ManualFiller<Book> {

    public ManualFillerBook(BufferedReader bufferedReader, List<Book> list) {
        super(bufferedReader, list);
    }

    @Override
    protected Book getValue() {
        String author = "";
        String title = "";
        int pages = 0;
        boolean is = true;
        while (is) {
            try {
                System.out.println("Enter author:\n");
                author = bufferedReader.readLine();
                System.out.println("Enter title:\n");
                title = bufferedReader.readLine();
                System.out.println("Enter pages:\n");
                pages = Integer.parseInt(bufferedReader.readLine());
                is = false;
            } catch (NumberFormatException ex) {
                System.out.println("This field only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        }
        Book book = Book.builder()
                .author(author)
                .title(title)
                .pages(pages)
                .build();
        return book;
    }

}
