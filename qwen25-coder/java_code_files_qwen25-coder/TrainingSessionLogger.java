import java.time.LocalDate;

public class TrainingSessionLogger {
    // Example: Logging training sessions for compliance.
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe");
        TrainingSession session = new TrainingSession(employee, "Data Security Practices", LocalDate.now());
        recordTrainingSession(session);
    }

    public static void recordTrainingSession(TrainingSession session) {
        // Record the training session
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }
}

class TrainingSession {
    private Employee employee;
    private String topic;
    private LocalDate date;

    public TrainingSession(Employee employee, String topic, LocalDate date) {
        this.employee = employee;
        this.topic = topic;
        this.date = date;
    }
}