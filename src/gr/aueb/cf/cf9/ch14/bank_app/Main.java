package gr.aueb.cf.cf9.ch14;

public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(15.8);
        Point p2 = new Point3D(2, 5.5, 0);
        Point p3 = new Point3D(2, 5.5, 10);

        p1.movePlusOne();
        p2.movePlus10();
        p3.movePlusOne();

        doMovePlus10(p1);
        doMovePlus10(p2);
        doMovePlus10(p3);

//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);

        doPrint(p1);
        doPrint(p2);
        doPrint(p3);
    }

    public static void doMovePlus10(Point p) {
        p.movePlus10();         // late binding
    }

    public static void doPrint(Point p) {
        System.out.println(p);
    }


}
