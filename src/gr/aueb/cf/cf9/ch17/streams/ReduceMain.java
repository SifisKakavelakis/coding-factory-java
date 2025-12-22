package gr.aueb.cf.cf9.ch17.streams;

import gr.aueb.cf.cf9.ch17.sorting.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Product> products = new ArrayList<>(List.of (
                new Product("Apples", 12.5, 10),
                new Product("Oranges", 8.1, 50),
                new Product("Milk", 2.8, 4),
                new Product("Apples", 22.5, 120)
        ));

        int totalSum = numbers.stream()
                .reduce(0, (sum, num) -> sum + num);

        int totalSum2 = numbers.stream()
                .reduce(0, Integer::sum);       // Integer has a static method sum()

        int sumOfQuantities = products.stream()
                .mapToInt(Product::getQuantity)
                .reduce(0, Integer::sum);

        int sumOfQuantities2 = products.stream()
                .mapToInt(Product::getQuantity)
                .sum();             // works with primitive types

        // Sorted list with product descriptions for quantities >= 100
        var sortedProductsDescriptionsGEQ100 = products.stream()
                .filter(p -> p.getQuantity() >= 100)
                .sorted(Comparator.comparing(Product::getDescription))  // products
                .map(Product::getDescription)                           // String
                .map(String::toUpperCase)
                .collect(Collectors.toCollection(ArrayList::new));

        sortedProductsDescriptionsGEQ100.forEach(System.out::println);


    }
}
