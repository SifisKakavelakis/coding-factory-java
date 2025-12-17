package gr.aueb.cf.cf9.ch17.lifo_parking;

public class Main {

    public static void main(String[] args) {

        LifoParking parking = new LifoParking();
        parking.addCar("IAE 3989");
        parking.addCar("BMA 1234");
        parking.addCar("VWI 9876");

        String car  = parking.removeCar();
        System.out.println(car);

        car = parking.removeCar();
        System.out.println(car);
    }
}
