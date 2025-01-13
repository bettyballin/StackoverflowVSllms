import java.lang.String;

public class Hotel {
  private Receptionist receptionist;

  public Hotel() {
    this.receptionist = new Receptionist();
  }

  public void bookRoom() {
    receptionist.bookRoom();
  }

  public void orderFood() {
    receptionist.orderFood();
  }

  public static void main(String[] args) {
    Hotel hotel = new Hotel();
    hotel.bookRoom();
    hotel.orderFood();
  }
}

class Receptionist {
  public void bookRoom() {
    System.out.println("Booking a room.");
  }

  public void orderFood() {
    System.out.println("Ordering food.");
  }
}