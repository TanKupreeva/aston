package org.example.entity;

public class Book {
    private final String author;
    private final String title;
    private final int pages;

    Book(String author, String title, int pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPages() {
        return this.pages;
    }

    public static class BookBuilder {
        private String author;
        private String title;
        private int pages;

        BookBuilder() {
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            return new Book(this.author, this.title, this.pages);
        }


    }
}