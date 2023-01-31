public class Tables {
    // Класс в котором хранится такие данные как, номер столика и его статус Занят/Свободен
    private int num;
    private boolean occupied;
    //Констурктор
    public Tables(int num) {
        this.num = num;
        this.occupied = false;
    }
    // Getters и Setters
    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
