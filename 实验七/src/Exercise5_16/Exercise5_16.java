package Exercise5_16;

import java.util.Scanner;

/**
 * Created by benjaminzhang on 22/04/2017.
 * Copyright © benjaminzhang 2017.
 */

abstract class Shape {
    double area, perimeter;

    abstract void computeArea();

    abstract void computePerimeter();

    void display() {
        System.out.println("Area is " + area);
        System.out.println("Perimeter is " + perimeter);
    }
}

class Triangle extends Shape {
    double a, h;

    Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    void computeArea() {
        area = a * h / 2;
    }

    void computePerimeter() {
        perimeter = -1;
    }

    @Override
    void display() {
        System.out.println("\nTriangle:");
        System.out.println("a: " + a + " h: " + h);
        super.display();
    }
}

class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    void computeArea() {
        area = width * height;
    }

    void computePerimeter() {
        perimeter = width * 2 + height * 2;
    }

    @Override
    void display() {
        System.out.println("\nRectangle:");
        System.out.println("width: " + width + " height: " + height);
        super.display();
    }
}

class Square extends Rectangle {
    Square(double a) {
        super(a, a);
    }

    @Override
    void display() {
        System.out.println("\nSquare:");
        System.out.println("a: " + width);
        System.out.println("Area is " + area);
        System.out.println("Perimeter is " + perimeter);
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void computeArea() {
        area = Math.PI * radius * radius;
    }

    void computePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    void display() {
        System.out.println("\nCircle:");
        System.out.println("radius: " + radius);
        super.display();
    }
}

public class Exercise5_16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input triangle's a and h:");
        Triangle tri = new Triangle(input.nextDouble(), input.nextDouble());
        System.out.println("Please input square's a:");
        Square squ = new Square(input.nextDouble());
        System.out.println("Please input circle's radius:");
        Circle cir = new Circle(input.nextDouble());
        tri.computeArea();
        squ.computeArea();
        cir.computeArea();
        tri.computePerimeter();
        squ.computePerimeter();
        cir.computePerimeter();
        tri.display();
        squ.display();
        cir.display();
    }
}
