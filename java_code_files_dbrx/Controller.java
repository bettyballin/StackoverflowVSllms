import java.lang.String;

enum Status {
    ACTIVE, INACTIVE;
}

public class Controller {
    public Class<Status> getStatusEnum() { return Status.class; }

    public static void main(String[] args) {
    }
}