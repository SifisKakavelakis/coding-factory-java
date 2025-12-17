package gr.aueb.cf.cf9.ch17.sets;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> bag = new HashSet<>();

        // add - No duplicates
        bag.add("apple");
        bag.add("banana");
        bag.add("orange");
        bag.add("apple");       // No duplicates alloed

        // Time-complexity O(1)
        if (bag.contains("apple")) {        // override equals
            bag.remove("apple");
        } else {
            System.out.println("Apple not included in the bag.");
        }
        bag.removeIf(item -> item.startsWith("b"));
        bag.forEach(System.out::println);
    }
}
