/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #5
Program: TestResizableCircle
*/

public class TestResizableCircle
{
    public static void main(String[] args) {
        ResizableCircle r1 = new ResizableCircle(10); // Create new ResizableCircle
        System.out.println(r1.getArea()); // Method taken from superclass
        System.out.println(r1.getPerimeter()); // Method taken from superclass

        r1.resize(150);  // Method taken from Resizable passed to subclass ResizableCircle

        System.out.println(r1.getArea()); // Method taken from superclass
        System.out.println(r1.getPerimeter()); // Method taken from superclass

        /*Resizable r2= new ResizableCircle(5);
        System.out.println(r2.getArea()); Methods come from Resizable and getArea() does not exist in Resizable
        System.out.println(r2.getPerimeter()); Methods come from Resizable and getPerimeter() does not exist in Resizable */

        r1.resize(150); // Method taken from Resizable passed to subclass ResizableCircle

        GeometricObject g1 = (GeometricObject)r1; // Casts ResizableCircle to GeometricObject
        System.out.println(g1.getArea()); // Method taken from GeometricObject passed to subclass Circle
        System.out.println(g1.getPerimeter()); // Method taken from GeometricObject passed to subclass Circle
    }
}