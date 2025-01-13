import java.util.Objects;

public class YourObject {
    private Object property1;
    private Object property2;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        YourObject other = (YourObject) obj;
        // compare desired properties here
        return Objects.equals(this.property1, other.property1) &&
               Objects.equals(this.property2, other.property2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property1, property2);
    }

    public static void main(String[] args) {
    }
}