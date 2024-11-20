public class CarDriver {
    public static void main(String[] args) {
        Car car = new Car(15);

        car.addGas(20);

        System.out.println(car.checkGas());
        System.out.println(car.getMiles());

        car.drive(100);

        System.out.println(car.checkGas());
        System.out.println(car.getMiles());

        car.addGas(5);

        System.out.println(car.checkGas());
    }
}
