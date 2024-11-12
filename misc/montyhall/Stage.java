public class Stage {
    private Door[] doors = new Door[3];
    private final int prizeDoor;
    private int pickedDoor;
    private int openedDoor;
    private int remainingDoor;

    public Stage(int pickedDoor) {
        prizeDoor = (int) (Math.random() * 3);
        this.pickedDoor = pickedDoor;

        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door(i == prizeDoor);
        }

    }

    public int getOtherDoor() {
        if(pickedDoor == prizeDoor) {

            int[] doorsToOpen = new int[2];

            int j = 0;
            for (int i = 0; i < doors.length; i++) {
                if(i != pickedDoor) {
                    doorsToOpen[j] = i;
                    j++;
                }
            }

            int door = doorsToOpen[(int) (Math.random() * 2)];
            openedDoor = door;
            doors[door].open();
            return door;

        } else {
            for (int i = 0; i < doors.length; i++) {
                if (i != pickedDoor && i != prizeDoor) {
                    doors[i].open();
                    openedDoor = i;
                    return i;
                }
            }
        }

        return 0;
    }

    public int getRemainingDoor() {
        for (int i = 0; i < doors.length; i++) {
            if(i != pickedDoor && i != openedDoor) {
                remainingDoor = i;
                return i;
            }
        }

        return 0;
    }

    public void switchDoor() {
        pickedDoor = remainingDoor;
    }

    public boolean checkSelection() {
        return doors[pickedDoor].isPrize();
    }
}
