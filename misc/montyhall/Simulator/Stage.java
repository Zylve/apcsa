public class Stage {
    private Door[] doors = new Door[3];
    private final int prizeDoor; // The door with the prize.
    private int pickedDoor; // The door the user picks.
    private int openedDoor; // The door that will be revealed to the user.
    private int remainingDoor; // The door that we will offer the choice to switch to.

    public Stage(int pickedDoor) {
        this.prizeDoor = (int)(Math.random() * 3); // Pick a random prize door from 0 to 3.
        this.pickedDoor = pickedDoor;

        for(int i = 0; i < doors.length; i++) {
            this.doors[i] = new Door(i == this.prizeDoor); // Set the prize door if the index is equal to the random int.
        }

    }

    public int getOtherDoor() {
        if(this.pickedDoor == this.prizeDoor) { // If the user selected the prize door on the first try:
            int[] doorsToOpen = new int[2];

            int j = 0;
            for(int i = 0; i < doors.length; i++) {
                if(i != this.pickedDoor) { // Add unselected doors to a separate array.
                    doorsToOpen[j] = i; // Add indices of unselected doors to the separate array.
                    j++; // Only iterate j (the index of the separate array), if the door is not the one the user selected.
                }
            }

            int door = doorsToOpen[(int)(Math.random() * 2)]; // Pick a random element of the separate array and get the door index.
            this.openedDoor = door; // Set the opened door to the random index.
            this.doors[door].open(); // Open the door.
            return door; // Return the index of the opened door.
        } else { // If the user did not the select the prize door on the first try:
            for(int i = 0; i < doors.length; i++) {
                if(i != this.pickedDoor && i != prizeDoor) { // Loop through to find the door we did not pick and that is not the prize door.
                    this.doors[i].open(); // Open the door.
                    this.openedDoor = i; // Set the opened door to the index of the door.
                    return i; // Return the index of the opened door.
                }
            }
        }

        return 0; // In case something went catastrophically wrong.
    }

    public int getRemainingDoor() { // Get the door that we will suggest them to switch to.
        for(int i = 0; i < doors.length; i++) {
            if(i != this.pickedDoor && i != this.openedDoor) { // Find the door that is not the user's pick and not already opened.
                this.remainingDoor = i; // Set the remaining door to the index of the door.
                return i; // Return the index of the remaining door.
            }
        }

        return 0;
    }

    public void switchDoor() {
        this.pickedDoor = this.remainingDoor; // Switch the picked door to the remaining door.
    }

    public boolean checkSelection() {
        return this.doors[this.pickedDoor].isPrize(); // Return whether the picked door is the prize door.
    }

    public int getPrizeDoor() {
        return this.prizeDoor;
    }
}
