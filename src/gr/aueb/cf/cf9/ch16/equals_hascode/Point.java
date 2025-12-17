package gr.aueb.cf.cf9.ch16.equals_hascode;

import java.util.Objects;

public class Point {

    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Point point)) return false;
        return this.getX() == point.getX() && getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
