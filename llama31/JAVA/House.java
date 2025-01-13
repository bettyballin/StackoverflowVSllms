import java.lang.String;

public class House {
  private String foundation;
  private String walls;
  private String roof;
  private String doors;

  public House(String foundation, String walls, String roof, String doors) {
    this.foundation = foundation;
    this.walls = walls;
    this.roof = roof;
    this.doors = doors;
  }

  // Added getters for the fields
  public String getFoundation() {
    return foundation;
  }

  public String getWalls() {
    return walls;
  }

  public String getRoof() {
    return roof;
  }

  public String getDoors() {
    return doors;
  }
}

public class HouseBuilder {
  private House house;

  public HouseBuilder() {
    this.house = new House("", "", "", "");
  }

  public HouseBuilder withFoundation(String foundation) {
    house.foundation = foundation;
    return this;
  }

  public HouseBuilder withWalls(String walls) {
    house.walls = walls;
    return this;
  }

  public HouseBuilder withRoof(String roof) {
    house.roof = roof;
    return this;
  }

  public HouseBuilder withDoors(String doors) {
    house.doors = doors;
    return this;
  }

  public House build() {
    return house;
  }
}

public class Main {
  public static void main(String[] args) {
    HouseBuilder builder = new HouseBuilder();
    House house = builder.withFoundation("Concrete")
                         .withWalls("Bricks")
                         .withRoof("Tiles")
                         .withDoors("Wooden")
                         .build();
    System.out.println("Foundation: " + house.getFoundation());
    System.out.println("Walls: " + house.getWalls());
    System.out.println("Roof: " + house.getRoof());
    System.out.println("Doors: " + house.getDoors());
  }
}