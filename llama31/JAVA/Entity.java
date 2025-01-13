import javax.persistence.Column;

public class Entity {
    @Column(columnDefinition = "VARCHAR2(255) NULL")
    private String myField;

    public static void main(String[] args) {
    }
}