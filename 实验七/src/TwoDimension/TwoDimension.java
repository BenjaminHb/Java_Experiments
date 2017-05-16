package TwoDimension;

import java.util.Random;

/**
 * Created by benjaminzhang on 16/05/2017.
 * Copyright © benjaminzhang 2017.
 */

class Point {
    double x, y;

    Point() {
        x = y = 0;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Circle extends Point {
    protected double radius;
    protected double area;

    Circle() {
        super();
    }

    Circle(double x, double y) {
        super(x, y);
    }

    double getRadius() {
        return radius;
    }

    void setRadius(double r) {
        radius = r;
    }

    void computeArea() {
        area = Math.PI * radius * radius;
    }
}

class Cylinder extends Circle {
    protected double height;
    protected double volume;

    Cylinder() {
        super();
    }

    Cylinder(double x, double y) {
        super(x, y);
    }

    double getHeight() {
        return height;
    }

    void setHeight(double h) {
        height = h;
    }

    void computeVolume() {
        computeArea();
        volume = area * height;
    }

    void display() {
        System.out.println("Point position: ( " + x + "," + y + " )");
        System.out.println("Radius: " + radius);
        System.out.println("Height: " + height);
        System.out.println("Area: " + area);
        System.out.println("Volume: " + volume);
    }
}

public class TwoDimension {
    public static void main(String[] args) {
        Cylinder[] array = new Cylinder[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = new Cylinder(random.nextInt(100), random.nextInt(100));
            array[i].setRadius(random.nextInt(25));
            array[i].setHeight(random.nextInt(25));
            array[i].computeArea();
            array[i].computeVolume();
            System.out.println("Cylinder " + i);
            array[i].display();
            System.out.println();
        }
    }
}
