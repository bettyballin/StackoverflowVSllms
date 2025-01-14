import java.util.List;
import java.util.ArrayList;

public class ScrumTask {
    private String status;
    private List<String> comments;

    public ScrumTask() {
        this.status = "To Do";
        this.comments = new ArrayList<>();
    }

    public void moveInProgress() {
        if (this.status.equals("To Do")) {
            this.status = "In Progress";
        }
    }

    public void requestVerification() {
        if (this.status.equals("In Progress")) {
            this.status = "To Verify";
        }
    }

    public void addComments(List<String> newComments) {
        this.comments.addAll(newComments);
    }

    public void addressComments() {
        // Developer addresses comments
        // Dummy method for example purposes
    }

    public boolean verifyTask() {
        // Verification logic here
        // Return true if all comments are resolved, false otherwise
        return this.comments.isEmpty(); // Simplified condition
    }

    public void moveToDone() {
        if (this.status.equals("To Verify") && verifyTask()) {
            this.status = "Done";
        }
    }

    public static void main(String[] args) {
    }
}