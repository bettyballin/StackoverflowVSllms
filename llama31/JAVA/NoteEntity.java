import java.lang.String;
import java.util.List;

import javax.persistence.CollectionOfElements;
import javax.persistence.Column;
import javax.persistence.IndexColumn;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;

public class NoteEntity {
    @CollectionOfElements(fetch = FetchType.EAGER)
    @JoinTable(name = "NOTE_JOIN_TABLE", joinColumns = @JoinColumn(name = "note"))
    @Column(name = "substitution", columnDefinition = "CLOB(100000)") // adjust the length to your needs
    @IndexColumn(name = "listIndex", base = 0)
    @Lob
    private List<String> substitutions;

    public static void main(String[] args) {
    }
}