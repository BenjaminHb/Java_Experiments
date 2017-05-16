/**
 * Created by benjaminzhang on 15/05/2017.
 * Copyright © benjaminzhang 2017.
 */

abstract class SuperClass {
    abstract void display();
}

class SubClassA extends SuperClass {
    void display() {
        System.out.println("SubClassA extends SuperClass. SubClassA");
    }
}

class SubClassB extends SuperClass {
    void display() {
        System.out.println("SubClassB extends SuperClass. SubClassB");
    }
}

class PolyTester {
    SuperClass[] array = new SuperClass[2];

    protected PolyTester() {
        array[0] = new SubClassA();
        array[1] = new SubClassB();
    }

    protected void tester() {
        for (int i = 0; i < 10; i++) {
            array[i % 2].display();
        }
    }
}

public class Exercise5_20 {
    public static void main(String[] args) {
        PolyTester pT = new PolyTester();
        pT.tester();
    }
}
