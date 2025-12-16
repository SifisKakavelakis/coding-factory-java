package gr.aueb.cf.cf9.ch16.builder_pattern;

public class Book {
    private final long id;
    private final String titile;
    private final String author;
    private final String isbn;

    private Book(Builder builder) {
        this.id = builder.id;
        this.titile = builder.title;
        this.author = builder.author;
        this.isbn = builder.isbn;
    }

    public static class Builder {
        private final long id;
        private final String isbn;
        private String title = "";
        private String author = "";

        public Builder(long id, String  isbn) {
            this.id = id;
            this.isbn = isbn;
        }

        // Fluent Setter - returns the Builder object
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

        public long getId() {
            return id;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
