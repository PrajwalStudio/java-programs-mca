package packageshape;

import Shape.Square;
import Shape.Triangle;
import Shape.Circle;

public class PackageShape {
    public static void main(String[] args) {
        Square s = new Square(4);
        Triangle t = new Triangle(5, 6);
        Circle c = new Circle(3);

        System.out.println("Area of Square: " + s.area());
        System.out.println("Area of Triangle: " + t.area());
        System.out.println("Area of Circle: " + c.area());
    }
}
