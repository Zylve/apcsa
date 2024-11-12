public class Dog {
    private String name;
    private double weight;

    public Dog(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void eatFood(double amount) {
        this.weight += amount;
    }

    public void poop() {
        this.weight -= Math.random() > 0.5 ? 2 : 1;
    }

    public void speak() {
        System.out.println("Bark!");
    }
}
