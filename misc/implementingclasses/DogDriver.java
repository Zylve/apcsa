public class DogDriver {

    public static void main(String[] args) {
        Dog dog = new Dog("Max", 10);

        System.out.println(dog.getWeight());
        dog.eatFood(2.5);
        System.out.println(dog.getWeight());

        dog.speak();

        dog.poop();
        dog.speak();
        System.out.println(dog.getWeight());
        dog.poop();
        dog.speak();
        System.out.println(dog.getWeight());
        dog.speak();
    }
}
