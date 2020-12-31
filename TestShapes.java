public class TestShapes
{
    public static void main(String[] args) {
        /*
        s1 will take all of the methods from Shape, not Circle
        If a method is not in Shape but in Circle, it will not work
        (getRadius() will not work because it is not in Shape)
        Also, if a method is contained in both Shape and Circle,
            it will use the Circle method
            (The first 5 will use the methods of Circle)
         */
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        //System.out.println(s1.getRadius());

        /*
        s1 is then explicitly casted to a Circle which means
        it now inherits the methods of the Circle class,
        so it now can use all the methods in the block of code below
         */
        Circle c1 = (Circle)s1;
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        Shape s2 = new Shape();

         /*
        s3 will take all of the methods from Shape, not Rectangle
        If a method is not in Shape but in Rectangle, it will not work
        (getLength() will not work because it is not in Shape)
        Also, if a method is contained in both Shape and Rectangle,
            it will use the Rectangle method
            (The first 4 will use the methods of Rectangle)
         */
        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        //System.out.println(s3.getLength());

        /*
        s3 is then explicitly casted to a Rectangle which means
        it now inherits the methods of the Rectangle class,
        so it now can use all the methods in the block of code below
         */
        Rectangle r1 = (Rectangle)s3;
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        /*
        s4 will take all of the methods from Shape, not Square
        If a method is not in Shape but in Square, it will not work
        (getSide() will not work because it is not in Square)
        Also, if a method is contained in both Shape and Square,
            it will use the Square method
            (The first 3 will use the methods of Square)
         */
        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        //System.out.println(s4.getSide());

        /*
        r2 is still a Square even after explicit casting
        so it will still take on the Square's toString()
         */
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2); // Uses method from Square
        System.out.println(r2.getArea()); // Uses method from Square
        System.out.println(r2.getColor()); // Uses method from Shape
        //System.out.println(r2.getSide); Not in Rectangle so causes errors
        System.out.println(r2.getLength()); // Uses methods from Rectangle

        /*
         r2 is then explicitly casted to a Square which means
        it now inherits the methods of the Square class,
        so it now can use all the methods in the block of code below
        getLength() will inherit the method from Rectangle
         */
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
    }
}