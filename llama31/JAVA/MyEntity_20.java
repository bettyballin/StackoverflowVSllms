import java.io.Serializable;

// Removing JPA annotations to make it compile without external dependencies
public class MyEntity_20_20 {
    private String column1;
    private String column2;

    // Other fields and getters/setters
    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }
}

class MyEntity_20PK implements Serializable {
    private String column1;
    private String column2;

    // Getters/setters
    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    // equals/hashCode implementations
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyEntity_20PK that = (MyEntity_20PK) o;

        if (!column1.equals(that.column1)) return false;
        return column2.equals(that.column2);
    }

    @Override
    public int hashCode() {
        int result = column1.hashCode();
        result = 31 * result + column2.hashCode();
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        MyEntity_20PK pk = new MyEntity_20PK();
        pk.setColumn1("value1");
        pk.setColumn2("value2");

        System.out.println("PK Column1: " + pk.getColumn1());
        System.out.println("PK Column2: " + pk.getColumn2());
    }
}