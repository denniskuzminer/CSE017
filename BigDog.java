public class BigDog extends Dog
{
    public void greeting() {
        System.out.println("Ummmm.... Bark");
    }

    public void greeting(Dog another) {
        System.out.println("Ummmm.... Bark Bark, " + another);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "BigDog";
    }
}