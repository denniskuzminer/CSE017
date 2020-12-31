public class Square extends Rectangle
{
    /**
     * No arg Constructor
     */
    public Square() {
        super();
    }

    /**
     * Creates a Square by making a Rectangle with 2 of the same sides
     * @param side Side of the square
     */
    public Square(double side) {
        super(side, side);
    }

    /**
     * Creates a Square by making a Rectangle with 2 of the same sides
     * @param side Side of the square
     * @param color Color of the square
     * @param filled Is the square fillied?
     */
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    /**
     * Getters, setters, and a toString()
     */
    public double getSide() {
        return super.getLength();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + getSide() +
                '}';
    }
}