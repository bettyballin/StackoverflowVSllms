// Define the State enum
public enum State {
    WAITING,
    READY
}

// Define the TaskObjectInterface interface
public interface TaskObjectInterface {
    State executeStep();
}

// Define the Scheduler interface
public interface Scheduler {
    void onStateChange(TaskObject taskObject);
}

// Define the TaskObject class
public class TaskObject implements TaskObjectInterface {
    private Scheduler scheduler;
    private State state;

    public TaskObject(Scheduler scheduler) {
        this.scheduler = scheduler;
        this.state = State.WAITING; // Initialize the state
    }

    public State executeStep() {
        // Assuming some logic to check for external condition complete
        boolean externalConditionComplete = true;
        
        if (state == State.WAITING && externalConditionComplete) {
            state = State.READY;
            scheduler.onStateChange(this);
        }
        return state;
    }

    public static void main(String[] args) {
        // Create a Scheduler instance
        Scheduler scheduler = new Scheduler() {
            public void onStateChange(TaskObject taskObject) {
                System.out.println("State changed to " + taskObject.executeStep());
            }
        };

        // Create a TaskObject instance
        TaskObject taskObject = new TaskObject(scheduler);

        // Execute the task
        taskObject.executeStep();
    }
}