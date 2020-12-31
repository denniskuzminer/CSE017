public class TestAnimal
{
    public static void main(String[] args) {
        //Using the subclass
        Cat cat1 = new Cat(); // Makes a new Cat no polymorphism
        cat1.greeting(); // Greeting from Cat
        Dog dog1 = new Dog(); // Makes a new Dog no polymorphism
        dog1.greeting(); // Greeting from Dog
        BigDog bigDog1 = new BigDog(); // Makes a new BigDog no polymorphism
        bigDog1.greeting(); // Greeting from BigDog

        //Using Polymorphism
        Animal animal1 = new Cat();
        animal1.greeting(); // Greeting from Cat. Because the method is declared in Animal but exists as well in Cat, Cat's method is displayed
        Animal animal2 = new Dog();
        animal2.greeting(); // Greeting from Dog. Because the method is declared in Animal but exists as well in Dog, Dog's method is displayed
        Animal animal3 = new BigDog();
        animal3.greeting(); // Greeting from BigDog. Because the method is declared in Animal but exists as well in BigDog, BigDog's method is displayed
        //Animal animal4 = new Animal(); Causes an error because Animal is abstract and abstract classses cannot be instantiated

        //Downcast
        Dog dog2 = (Dog)animal2;
        BigDog bigDog2 = (BigDog)animal3;
        Dog dog3 = (Dog)animal3;
        //Cat cat2 = (Cat)animal2; Animal2 is cast to a Dog and because it is a Dog and is not above or below Cat it cannot be cast to a Cat
        // it wouldn't be Upcasted or Downcasted... it would be Sidecasted??? 🤔🤔🤔🤔🤔🤔🤔 hmmmmm....
        dog2.greeting(dog3); // dog2 uses Dog methods. Dog3 is a BigDog but is casted to a Dog when the method is called
        dog3.greeting(dog2); // dog3 uses BigDog methods. Dog2 is a Dog
        dog2.greeting(bigDog2); // dog2 uses Dog methods. BigDog2 is a BigDog but passes through the parameter of greeting because a BigDog is a Dog
        bigDog2.greeting(dog2); // bigDog2 uses BigDog methods. Dog2 is a Dog
        bigDog2.greeting(bigDog1); // bigDog2 uses BigDog methods. BigDog1 is a BigDog but passes through the parameter of greeting because a BigDog is a Dog
    }
}