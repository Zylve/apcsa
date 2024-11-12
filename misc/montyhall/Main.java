public class Main {
    public static void main(String[] args) {
        System.out.println("Hi, I am Monty! Welcome to the Monty Hall game!");
        System.out.print("Please select door 1, 2 or 3: ");
        int doorNumber = Integer.parseInt(System.console().readLine());
        System.out.println("Excellent choice!");

        Stage stage = new Stage(doorNumber - 1);
        int otherDoor = stage.getOtherDoor();
        System.out.println("I will now open another door without a prize");
        System.out.println((otherDoor + 1) + " does not contain a prize.");

        int remainingDoor = stage.getRemainingDoor();
        System.out.print("Would you like to switch to door " + (remainingDoor + 1) + "? Y/N: ");
        String switchDoor = System.console().readLine();

        if(switchDoor.equalsIgnoreCase("Y")) {
            stage.switchDoor();
        }

        boolean won = stage.checkSelection();
        if(won) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Sorry, you did not win.");
        }
    }
}
