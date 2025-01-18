import java.lang.String;

public class HouseBuilder {

    private int windows;
    private int doors;

    House house = new HouseBuilder().setWindows(5).setDoors(2).build();

    public HouseBuilder setWindows(int windows) {
        this.windows = windows;
        return this;
    }

    public HouseBuilder setDoors(int doors) {
        this.doors = doors;
        return this;
    }

    public House build() {
        return new House(windows, doors);
    }

    public static void main(String[] args) {
    }
}

class House {
    private int windows;
    private int doors;

    public House(int windows, int doors) {
        this.windows = windows;
        this.doors = doors;
    }
}