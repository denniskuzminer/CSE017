/**
 * CSE 017 Fall 2019
 * @author Dennis Kuzminer
 * HW #3
 * Program: Person/ Student/ Teacher
 */

public class Person
{
    private String name;
    private String address;

    /**
     * Constructs Person
     * @param name Name
     * @param address Address
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Getters and Setters
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Converts memeory location to user-friendly String
     * @return Example: Thorn McNally(1754 Falcon Drive)
     */
    public String toString() {
        return name + "(" + address + ")";
    }
}