public class Vehicle
{
    int speed;

    public Vehicle(int speed) {
        this.speed = speed;
        System.out.println("Vehicle 1-arg");
    }

    public Vehicle() {
        this(0);
        System.out.println("Vehicle 0-arg");
    }
}
class Car extends Vehicle {
    private String make;
    private String model;

    public Car(int speed, String make, String model) {
        super(speed);
        this.make = make;
        this.model = model;
        System.out.println("Car 3-arg");
    }

    public Car() {
        this.make = "N/A";
        this.model = "N/A";
        System.out.println("Car 0-arg");
    }
}
class Truck extends Car {
    double towCapacity;

    public Truck(double towCapacity, int speed, String make, String model) {
        super(speed, make, model);
        this.towCapacity = towCapacity;
        System.out.println("Truck 4-arg");
    }

    public Truck(double towCapacity) {
        this.towCapacity = towCapacity;
        System.out.println("Truck 1-arg");
    }
}

