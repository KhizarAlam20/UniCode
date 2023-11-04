public class K213868_QUESTION03_TASK02 {
    public static void main(String[] args) {
        Triangles t = new Triangles(12,13);
        System.out.println("Triangle area is = "+t.area()+" Perimeter is = "+t.perimeter());
        Square s = new Square(1);
        System.out.println("Square area is = "+s.area()+" Perimeter is = "+s.perimeter());
    }
}
abstract  class geometricShape
{
    abstract double area();
    abstract double perimeter();
}


class Triangles extends geometricShape {
    private double side1;
    private double side2;

    public Triangles(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double area() {

        double s = (side1 * side2) / 2;
        return s;
    }

    @Override
    public double perimeter() {
        return side1 + side2;
    }
}

// Subclass Square
class Square extends geometricShape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }
}