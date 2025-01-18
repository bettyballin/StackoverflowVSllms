import javax.persistence.Column;

public class TextDescriptionEntity {
    @Column(columnDefinition = "TEXT")
    private String description;

    public static void main(String[] args) {
    }
}