package geometry_package_program;

import geometry_package_program.geometry.Circle;
import geometry_package_program.geometry.Rectangle;
import geometry_package_program.geometry.Triangle;

public class GeometryPackageDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(3.3);
        System.out.println("Area of circle: "+String.format("%.2f", circle.getArea()));
        System.out.println("Perimeter of circle: "+String.format("%.2f",circle.getPerimeter()));

        Triangle triangle = new Triangle(5, 8);
        System.out.println("Area of triangle: "+String.format("%.2f",triangle.getArea()));
        System.out.println("Perimeter of triangle: "+String.format("%.2f", triangle.getPerimeter()));

        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println("Area of rectangle: "+String.format("%.2f",rectangle.getArea()));
        System.out.println("Perimeter of rectangle: "+String.format("%.2f",rectangle.getPerimeter()));

    }
}
