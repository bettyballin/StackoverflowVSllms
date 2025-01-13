import javax.persistence.Column;

public class StatusFlag {
    @Column(columnDefinition = "BIT")
    private boolean active;

    public static void main(String[] args) {
    }
}