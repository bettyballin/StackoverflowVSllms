import java.lang.String;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

public class ClassA_1_1 {
    @OrderBy(clause = "classC.name asc", property = "classC")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COLUMN_NAME")
    private List<ClassB> lotsOfClasses;

    public static void main(String[] args) {
    }
}