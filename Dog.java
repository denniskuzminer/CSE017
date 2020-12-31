public class Dog extends Animal
{
    public void greeting() {
        System.out.println("Ummmm.... Woof");
    }

    public void greeting(Dog another) {
        System.out.println("Ummmm.... Woof Woof, " + another);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Dog";
    }
}