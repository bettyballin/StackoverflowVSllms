import java.util.List;

import javax.persistence.CollectionOfElements;
import javax.persistence.Column;
import javax.persistence.IndexColumn;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.FetchType;

import org.hibernate.annotations.Type;

public class AnnotationConfiguredSubstitutionList {
    @CollectionOfElements(fetch = FetchType.EAGER)
    @JoinTable(name = "NOTE_JOIN_TABLE", joinColumns = @JoinColumn(name = "note"))
    @Column(name = "substitution")
    @IndexColumn(name = "listIndex", base = 0)
    @Type(type = "org.hibernate.type.MaterializedClobType")
    private List<String> substitutions;

    public static void main(String[] args) {
    }
}