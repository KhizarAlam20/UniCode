import java.util.Scanner;

public class K213868_QUESTION01_TASK01 {
    public static void main(String[] args) {
        System.out.println("Q1 TASK1 K213868\n--------------------");
        double AREA;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----------CIRCLE----------\n");
        System.out.print("Enter radius : ");
        circle c = new circle(sc.nextDouble());
        AREA = c.getArea();
        System.out.println("Circle Area = "+AREA);


        System.out.println("\n----------RECTANGLE----------\n");
        System.out.println("Enter Length and Breadth : ");
        Rectangle r = new Rectangle(sc.nextDouble(), sc.nextDouble());
        AREA = r.getArea();
        System.out.println("Rectangle Area = "+AREA);


        System.out.println("\n----------TRIANGLE ----------\n");
        System.out.println("Enter Length and Breadth : ");
        Triangle t = new Triangle(sc.nextDouble(),sc.nextDouble());
        AREA = t.getArea();
        System.out.println("Triangle Area = "+AREA);
    }
}

interface SHAPE {
    double getArea();
}

class circle implements SHAPE {

    double RADIUS;
    double AREA;

    public circle(double RADIUS) {
        this.RADIUS = RADIUS;
    }

    @Override
    public double getArea() {
        AREA = (Math.PI) * (RADIUS * RADIUS);
        return AREA;
    }
}

class Rectangle implements SHAPE {
    double LENGTH, BREADTH;
    double AREA;

    public Rectangle(double LENGTH, double BREADTH) {
        this.LENGTH = LENGTH;
        this.BREADTH = BREADTH;
    }

    @Override
    public double getArea() {
        AREA = (LENGTH * BREADTH);
        return AREA;
    }

}

class Triangle implements SHAPE {
    double LENGTH, BREADTH;
    double AREA;

    public Triangle(double LENGTH, double BREADTH) {
        this.LENGTH = LENGTH;
        this.BREADTH = BREADTH;
    }

    @Override
    public double getArea() {
        AREA = (0.5) * (LENGTH * BREADTH);
        return AREA;
    }
}