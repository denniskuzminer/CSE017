public class Shape
{
    protected String color;
    protected boolean filled;

    /**
     * Constructs a shape with color and whether it's filled
     * @param color Color of Shape
     * @param filled is Shape filled?
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**
     * No arg constructor
     */
    public Shape() {
        this.color = "null";
        this.filled = false;
    }

    /**
     * Getters, setters, toString()
     */
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Just returns a default value. Doesn't actually do anything
     */
    public double getArea() {
        return -1;
    }

    /**
     * Just returns a default value. Doesn't actually do anything
     */
    public double getPerimeter() {
        return -1;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}