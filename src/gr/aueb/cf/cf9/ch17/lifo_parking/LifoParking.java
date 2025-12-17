package gr.aueb.cf.cf9.ch17.lifo_parking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class LifoParking {

    private final Deque<String> parking = new LinkedList<>();

    public LifoParking() {

    }

    public List<String> getParking() {
        return List.copyOf(parking);
    }

    public void addCar(String car) {
        parking.push(car);
        System.out.println(LocalDateTime.now() + ": " + ", Εισοδος, Αρ. Πινακιδας=  " + car);
    }

    public String removeCar() {
        String car = parking.pop();
        System.out.println(LocalDateTime.now() + "Εξοδος, Αρ. Πινακιδας=" + car);
        return car;
    }

    public boolean isEmpty() {
        return parking.isEmpty();
    }

    public void traverse() {
        parking.forEach(System.out::println);
    }
}
