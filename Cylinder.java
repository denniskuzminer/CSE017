public class Cylinder extends Circle
{
    private double height;
    private double radius;
    private String color;

    public Cylinder() {
        super();
        height = 1.0;
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        return "Circle[radius=" + getRadius() + ", color=" + getColor() + ", height=" + height + "]";
    }

    public double getVolume() {
        return this.getArea() * height;
    }
}