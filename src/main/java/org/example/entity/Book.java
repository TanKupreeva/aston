package org.example.entity;

public class Book {
    private final String author;
    private final String title;
    private final int page;

    private Book(BookBuilder bookBuilder) {
        this.author = bookBuilder.author;
        this.title = bookBuilder.title;
        this.page = bookBuilder.page;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public int getPage_count() {
        return page;
    }

    public static class BookBuilder {
        private String author;
        private String title;
        private int page;

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder page(int page) {
            this.page = page;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}