import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.util.Set;
import java.util.EnumSet;

public enum WicketType {
    TYPE1, TYPE2, TYPE3 // Example enum values
}

public class Wicket_1_1 {
    @ElementCollection
    @CollectionTable(name = "Wicket_WicketType", joinColumns = @JoinColumn(name = "W_ID"))
    @Column(name = "W_TypeId")
    @Enumerated(EnumType.ORDINAL)
    private Set<WicketType> types;

    public Wicket_1() {
        this.types = EnumSet.noneOf(WicketType.class);
    }

    public static void main(String[] args) {
        Wicket_1 wicket = new Wicket_1();
        // Example usage
        wicket.types.add(WicketType.TYPE1);
        System.out.println(wicket.types);
    }
}