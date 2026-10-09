package week9.class_problems;

import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    abstract double getArea();
    abstract String getShape();
}

class Circle extends Plot {
    private double radius;

    public Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    private double length;
    private double width;

    public Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    private double base;
    private double height;

    public Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }

    public String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot plot;

            if (shape.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                plot = new Circle(owner, radius);
            } else if (shape.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plot = new Rectangle(owner, length, width);
            } else {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plot = new Triangle(owner, base, height);
            }

            double area = plot.getArea();
            total += area;

            System.out.printf("%s (%s): %.2f%n",
                    plot.owner, plot.getShape(), area);
        }

        System.out.printf("Total Area: %.2f%n", total);

        sc.close();
    }
}