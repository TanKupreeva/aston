package org.example.soututils;

import org.example.entity.Book;

import java.io.BufferedReader;
import java.io.IOException;

public class GetValueBook extends GetValue<Book>{

    public GetValueBook(BufferedReader bufferedReader) {
        super(bufferedReader, null);
        function = this::getValue;
    }

    public Book getValue(int i) {
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
                        (i != -1 ? "Try filling object number " + i + " again." : "Try again."));
            } catch (IOException e) {
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
