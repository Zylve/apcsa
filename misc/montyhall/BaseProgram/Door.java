public class Door {
    private boolean isPrize;
    private boolean isOpen;

    public Door(boolean isPrize) {
        this.isPrize = isPrize;
        this.isOpen = false;
    }

    public boolean isPrize() {
        return isPrize;
    }

    public void open() {
        isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
