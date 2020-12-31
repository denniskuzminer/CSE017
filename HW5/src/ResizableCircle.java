/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #5
Program: ResizableCircle
*/

public class ResizableCircle extends Circle implements Resizable
{
    /**
     * Constucts a ResizableCircle given the radius
     * @param radius Radius of the Circle
     */
    public ResizableCircle(double radius) {
        super(radius);
    }

    /**
     * Resizes the radius of a ResizableCircle by a given percent
     * @param percent Should be an int
     */
    public void resize(int percent) {
        super.radius = (double) super.radius * percent / 100;
    }
}