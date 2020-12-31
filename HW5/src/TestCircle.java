/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #5
Program: TestCircle
*/

public class TestCircle
{
    public static void main(String[] args) {
        Circle c1 = new Circle(4); // Create new Circle
        System.out.println(c1.getArea()); // Method taken from Circle
        System.out.println(c1.getPerimeter()); // Method taken from Circle

        GeometricObject g1 = (GeometricObject)c1; // Casts Circle to GeometricObject
        System.out.println(g1.getArea()); // Method taken from GeometricObject passed to subclass Circle
        System.out.println(g1.getPerimeter()); // Method taken from GeometricObject passed to subclass Circle

        /*ResizableCircle r1 = (ResizableCircle) g1; ResizableCircle has no direct relation to GeometricObject so it won't run
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());*/

        Circle c2 = new ResizableCircle(5); // Creates a ResizableCircle with Circle methods
        System.out.println(c2.getArea()); // Method taken from superclass
        System.out.println(c2.getPerimeter()); // Method taken from superclass

        GeometricObject g2 = new Circle(6); // Creates a Circle with GeometricObject methods
        System.out.println(g2.getArea()); // Method taken from GeometricObject passed to subclass Circle
        System.out.println(g2.getPerimeter()); // Method taken from GeometricObject passed to subclass Circle
    }
}