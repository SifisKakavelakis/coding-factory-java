package gr.aueb.cf.cf9.ch17;

import java.util.List;

public class GenericMethods {

    public static void main(String[] args) {
        String[] strings = {"Athens", "Berlin", "Paris"};
        Integer[] integers = {1, 2, 3};

        printArray(strings);
        printArray(integers);
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void print(GenericNode<?> node) {
        System.out.println(node.getValue());
    }

    public static void printNumbers(GenericNode<? extends Number> node) {
        System.out.println(node.getValue());
    }

    public static void printNumbers2(GenericNode<? super Integer> node) {
        System.out.println(node.getValue());
    }

    private static <T> void produceConsume(List<? super T> list, Iterable<? extends T> src ) {
        for (T item: src) {
            list.add(item);
        }
    }
}
