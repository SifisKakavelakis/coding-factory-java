package gr.aueb.cf.cf9.ch16.builder_pattern;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book.Builder(1, "A123").build();
        Book book2 = new Book.Builder(2, "B456")
                .author("Androutsos")
                .title("Java")
                .build();

        Book book3 = new Book.Builder(3, "C789")
                .title("Javascript")
                .build();
    }
}
