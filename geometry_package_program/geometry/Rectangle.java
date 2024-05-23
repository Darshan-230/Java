package geometry_package_program.geometry;

public class Rectangle {
    private int width, length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public double getArea(){
        return width * length;
    }
    public double getPerimeter(){
        return 2 * (length + width);
    }
}
