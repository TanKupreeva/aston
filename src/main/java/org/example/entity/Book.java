package org.example.entity;

class Book {
    private final String author;
    private final String title;
    private final int page_count;

    private Book(BookBuilder bookBuilder) {
        this.author = bookBuilder.author;
        this.title = bookBuilder.title;
        this.page_count = bookBuilder.page_count;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public int getPage_count() {
        return page_count;
    }

    public static class BookBuilder {
        private String author;
        private String title;
        private int page_count;

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setYear(int year) {
            this.page_count = page_count;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}