package inheritanceinterface;

//a) Inheritance using class A, B, C
class A {

    void displayA() {
        System.out.println("This is class A");
    }
}

class B extends A {

    void displayB() {
        System.out.println("This is class B");
    }
}

class C extends B {

    void displayC() {
        System.out.println("This is class C");
    }
}

// b) Multiple Inheritance using Interface Area 
interface Area {

    void calculate(double x, double y);
}

class Rectangle implements Area {

    public void calculate(double l, double b) {
        System.out.println("Area of Rectangle: " + (l * b));
    }
}

class Triangle implements Area {

    public void calculate(double b, double h) {
        System.out.println("Area of Triangle: " + (0.5 * b * h));
    }
}

//Main Class to run both examples 
public class InheritanceInterface {

    public static void main(String[] args) {

        System.out.println("---- a) Inheritance Example ----");
        C obj = new C();
        obj.displayA();
        obj.displayB();
        obj.displayC();

        System.out.println("\n---- b) Multiple Inheritance using Interface ----");
        Rectangle rect = new Rectangle();
        Triangle tri = new Triangle();

        rect.calculate(5, 4);  
        tri.calculate(6, 3);  
    }
}
