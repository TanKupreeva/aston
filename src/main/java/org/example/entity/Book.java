package org.example.entity;

public class Book {
    private final String author;
    private final String title;
    private final int page;

    Book(String author, String title, int page) {
        this.author = author;
        this.title = title;
        this.page = page;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + page +
                '}';
    }

    public static BookBuilder builder() {
        return new BookBuilder();
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

        public BookBuilder page(int page) {
            this.page = page;
            return this;
        }

        public Book build() {
            return new Book(this.author, this.title, this.page);
        }

        public String toString() {
            return "Book.BookBuilder(author=" + this.author + ", title=" + this.title + ", pages=" + this.page + ")";
        }
    }
}