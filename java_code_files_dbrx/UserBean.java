// import java.lang.String; // unnecessary, java.lang is automatically imported

class UserBean {
    private City city; // city with name id and value that comes from combobox
    // your getter setters here (of city)....
}

public class City {
    /* assuming it has properties id and name, adjust according to your implementation */
    private String id;
    private String name;
    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }
    // getter setters omitted for the sake of brevity....

    public static void main(String[] args) {
    }
}