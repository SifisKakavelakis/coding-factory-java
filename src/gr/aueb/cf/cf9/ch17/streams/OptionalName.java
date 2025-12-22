package gr.aueb.cf.cf9.ch17.streams;

import gr.aueb.cf.cf9.ch17.sorting.Product;

import java.util.ArrayList;
import java.util.List;

public class OptionalName {

    public static void main(String[] args) throws Exception {

        List<Product> products = new ArrayList<>(List.of(
                new Product("Apples", 12.5, 10),
                new Product("Oranges", 8.1, 50),
                new Product("Milk", 2.8, 4),
                new Product("Apples", 22.5, 120)
        ));

//    Product product = products.stream()
//            .filter(p -> p.getPrice() >= 20)
//            .findFirst()
//            .orElse(new Product("No product found", 0, 0));

        Product product = products.stream()
                .filter(p -> p.getPrice() >= 20)
                .findFirst()
                .orElseThrow(() -> new Exception("No product found"));

    }
}