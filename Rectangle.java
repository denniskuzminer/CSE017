public class Rectangle extends Shape
{
    protected double width;
    protected double length;

    /**
     * Creates a Rectangle given a width and a length
     * @param width Width of the Rectangle
     * @param length Length  of the Rectangle
     */
    public Rectangle(double width, double length) {
        super("null", false);
        this.width = width;
        this.length = length;
    }

    /**
     * No arg Constructor
     */
    public Rectangle() {
        super("null", false);
        this.width = -1;
        this.length = -1;
    }

    /**
     * Creates a Rectangle given a width, a length, a color, and whether it's filled
     * @param width Width of the Rectangle
     * @param length Length  of the Rectangle
     * @param color Color of the Rectangle
     * @param filled Is the Rectangle fillied?
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * Getters, Setters, toString()
     */
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }

    /**
     * Gets perimeter by adding all the sides
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        return width * 2 + 2* length;
    }

    /**
     * Gets the area by doing width times length
     * @return area
     */
    @Override
    public double getArea() {
        return width * length;
    }
}