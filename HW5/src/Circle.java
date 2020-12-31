/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #5
Program: Circle
*/

public class Circle implements GeometricObject
{
    protected double radius;

    /**
     * Constucts a Circle given the radius
     * @param radius Radius of the Circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Gets the circumference of the circle
     * @return pi * r * 2
     */
    @Override
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    /**
     * Finds the area of a circle
     * @return pi * r^2
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}