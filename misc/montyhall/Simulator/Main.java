public class Main {
    public static void main(String[] args) {
        int iterations = 50;
        int noSwitchWins = 0;
        int switchWins = 0;

        for(int i = 0; i < iterations; i++) {
            int pickedDoor = (int)(Math.random() * 3);
            Stage stage = new Stage(pickedDoor);

            int otherDoor = stage.getOtherDoor();
            stage.getRemainingDoor();

            boolean won = stage.checkSelection();
            if(won) {
                noSwitchWins++;
            }

            System.out.printf(
                "Trial: %3d | Won: %-5b | Picked door: %d | Opened door: %d | Prize door: %d | %8s |\n",
                i + 1, won, pickedDoor + 1, otherDoor + 1, stage.getPrizeDoor() + 1, "No Switch"
            );
        }

        System.out.println("\n\n\n");

        for(int i = 0; i < iterations; i++) {
            int pickedDoor = (int)(Math.random() * 3);
            Stage stage = new Stage(pickedDoor);

            int otherDoor = stage.getOtherDoor();
            stage.getRemainingDoor();
            stage.switchDoor();

            boolean won = stage.checkSelection();
            if(won) {
                switchWins++;
            }

            System.out.printf(
                "Trial: %3d | Won: %-5b | Picked door: %d | Opened door: %d | Prize door: %d | %8s |\n",
                i + 1, won, pickedDoor + 1, otherDoor + 1, stage.getPrizeDoor() + 1, "Switch"
            );
        }

        System.out.println("\n\n\n");
        System.out.printf("No switch wins: %d | %3.1f%% |\n", noSwitchWins, (double)noSwitchWins / iterations * 100);
        System.out.printf("No switch losses %d | %3.1f%% |\n", iterations - noSwitchWins, (double)(iterations - noSwitchWins) / iterations * 100);
        System.out.println();
        System.out.printf("Switch wins: %d | %3.1f%% |\n", switchWins, (double)switchWins / iterations * 100);
        System.out.printf("Switch losses %d | %3.1f%% |\n", iterations - switchWins, (double)(iterations - switchWins) / iterations * 100);
    }
}
