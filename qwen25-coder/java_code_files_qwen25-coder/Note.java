import javax.persistence.*;
import java.util.List;

@Entity
public class Note {

    @Id
    private Long id;

    // Other fields and methods

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "NOTE_JOIN_TABLE", joinColumns = @JoinColumn(name = "note_id"))
    @Column(name = "substitution")
    private List<String> substitutions;

    // Getters and setters

    public static void main(String[] args) {
    }
}