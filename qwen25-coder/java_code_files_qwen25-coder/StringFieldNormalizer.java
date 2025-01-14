public class StringFieldNormalizer {

    private String yourStringField;

    @PrePersist
    public void prePersist() {
        if (this.yourStringField != null && this.yourStringField.isEmpty()) {
            this.yourStringField = null;
        }
    }

    @PreUpdate
    public void preUpdate() {
        if (this.yourStringField != null && this.yourStringField.isEmpty()) {
            this.yourStringField = null;
        }
    }

    public static void main(String[] args) {
        // Main method body
    }
}

@interface PrePersist {}

@interface PreUpdate {}