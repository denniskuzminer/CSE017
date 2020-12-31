public class Main {

    public static void main(String[] args) {
	    B thing = new B();
	    System.out.println(thing.toString());
    }
}
class A {
    public String toString() {
        return "This is it.";
    }
}
class B extends A{}
