package constuctoroverloading;

class Box {
    double width, height, depth;

    // Constructor Overloading
    Box() {
        width = height = depth = 0;
    }

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    Box(double len) {
        width = height = depth = len;
    }

    // Method Overloading
    void showArea(double l, double b) {
        System.out.println("Rectangle Area: " + (l * b));
    }

    void showArea(double s) {
        System.out.println("Square Area: " + (s * s));
    }

    double volume() {
        return width * height * depth;
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {
        Box b1 = new Box();
        Box b2 = new Box(2, 3, 4);
        Box b3 = new Box(5);

        System.out.println("Volume of b1: " + b1.volume());
        System.out.println("Volume of b2: " + b2.volume());
        System.out.println("Volume of b3: " + b3.volume());

        b2.showArea(4, 6); // Rectangle
        b3.showArea(3);    // Square
    }
}
