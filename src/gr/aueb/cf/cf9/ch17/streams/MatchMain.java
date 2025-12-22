package gr.aueb.cf.cf9.ch17.streams;

import java.util.List;

public class MatchMain {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Costas");
        List<Integer> numbers = List.of(2, 4, 6);

        boolean areAllEven = numbers.stream()
                .allMatch(num -> num % 2 == 0);

        boolean isAliceExists = names.stream()
                .anyMatch(name -> name.equals("Alice"));

        boolean allAreAlice = names.stream()
                .allMatch(name -> name.equals("Alice"));

        boolean noneIsAlice = names.stream()
                .noneMatch(name -> name.equals("Alice"));
    }
}
