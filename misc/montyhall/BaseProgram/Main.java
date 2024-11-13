public class Main {
    public static void main(String[] args) {
        // Note that our stage object has 0-indexed doors, so we need to shift everything over when communicating with the user.

        System.out.println("Hi, I am Monty! Welcome to the Monty Hall game!");
        System.out.print("Please select door 1, 2 or 3: ");
        int doorNumber = Integer.parseInt(System.console().readLine());
        if(doorNumber < 1 || doorNumber > 3) {
            System.out.println("Invalid door number. Please select door 1, 2 or 3.");
            return;
        }

        System.out.println("Excellent choice!");

        Stage stage = new Stage(doorNumber - 1); // Instatiate a stage object.
        int otherDoor = stage.getOtherDoor(); // Get the door that will be opened.
        System.out.println("I will now open another door without a prize");
        System.out.println((otherDoor + 1) + " does not contain a prize.");

        int remainingDoor = stage.getRemainingDoor(); // Get the door that we will suggest them to switch to.
        System.out.print("Would you like to switch to door " + (remainingDoor + 1) + "? Y/N: ");
        String switchDoor = System.console().readLine();
        if(!switchDoor.equalsIgnoreCase("Y") && !switchDoor.equalsIgnoreCase("N")) {
            System.out.println("Invalid input. Please enter Y or N.");
            return;
        }

        if(switchDoor.equalsIgnoreCase("Y")) {
            stage.switchDoor();
        }

        boolean won = stage.checkSelection(); // Check if the user won.
        if(won) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Sorry, you did not win.");
        }
    }
}
