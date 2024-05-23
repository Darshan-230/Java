package geometry_package_program.geometry;

public class Triangle {
    private  double a,b,c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea(){
        double semiperimeter = (a + b + c) / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));
    }
    public double getPerimeter(){
        return (a+b+c);
    }
}
