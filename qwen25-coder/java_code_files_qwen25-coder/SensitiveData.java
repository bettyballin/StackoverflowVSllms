public @interface Secured {
    String role();
}

public @interface Entity {
}

public @interface Id {
}

@Secured(role = "admin")
@Entity
public class SensitiveData {
    @Id
    private Long id;
    private String data;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static void main(String[] args) {
    }
}