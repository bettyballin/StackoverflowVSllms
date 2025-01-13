/*
 * Decompiled with CFR 0.152.
 */
public class Hotel {
    private Receptionist receptionist = new Receptionist();

    public void bookRoom() {
        this.receptionist.bookRoom();
    }

    public void orderFood() {
        this.receptionist.orderFood();
    }

    public static void main(String[] stringArray) {
        Hotel hotel = new Hotel();
        hotel.bookRoom();
        hotel.orderFood();
    }
}
