public class Car {
    private double milesPerGallon;
    private double gas;
    private double odometer;

    public Car(double milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
        this.gas = 0;
        this.odometer = 0;
    }

    public void addGas(double gallons) {
        this.gas += gallons;
    }

    public double checkGas() {
        return this.gas;
    }

    public double getMiles() {
        return this.odometer;
    }

    public void drive(double miles) {
        this.odometer += miles;
        this.gas -= miles / this.milesPerGallon;
    }
}