import org.apache.commons.lang3.builder.EqualsBuilder;

public class Bar_1_1 {
    private Object outer;
    private int myInt;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar_1 other = (Bar_1) o;
        return new EqualsBuilder()
                .append(outer, other.outer)
                .append(myInt, other.myInt)
                .isEquals();
    }

    public static void main(String[] args) {
    }
}