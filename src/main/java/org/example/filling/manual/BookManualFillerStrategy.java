package org.example.filling.manual;

import org.example.entity.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BookManualFillerStrategy extends ManualFillerStrategy<Book> {

    public BookManualFillerStrategy(List<Book> list) {
        super(list);
    }

    @Override
    protected Book getV() {
        String author = "";
        String title = "";
        int pages = 0;
        boolean is = true;
        while (is) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
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
