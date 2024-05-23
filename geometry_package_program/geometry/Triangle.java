package geometry_package_program.geometry;

public class Triangle {
    private  double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }


    public double getArea(){
       return (base * height) / 2;
    }
    public double getPerimeter(){
        double hypotenuse = Math.sqrt(base * base + height * height);
        return (base + height + hypotenuse);
    }
}
