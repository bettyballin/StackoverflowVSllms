import javax.persistence.OrderBy;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import java.util.List;

public class ClassA {
    @OrderBy(clause = "classC.name asc")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COLUMN_NAME")
    private List<ClassB> lotsOfClasses;

    public static void main(String[] args) {
    }
}