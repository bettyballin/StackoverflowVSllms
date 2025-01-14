import java.lang.String;
import java.util.LinkedList;
import java.util.Queue;

public class WorkflowScheduler {
    private Queue<TaskObject> readyQueue = new LinkedList<>();
    private Queue<TaskObject> waitingQueue = new LinkedList<>();
    private Queue<TaskObject> doneQueue = new LinkedList<>();

    public WorkflowScheduler(TaskObject[] tasks) {
        for (TaskObject task : tasks) {
            readyQueue.add(task);
        }
    }

    public void process() {
        while (!readyQueue.isEmpty() || !waitingQueue.isEmpty()) {
            // Process all READY objects
            TaskObject task = readyQueue.poll();
            if (task != null) {
                TaskObject.State state = task.executeStep();
                moveTaskToAppropriateQueue(task, state);
            }

            // Check WAITING queue for changes and move to READY if necessary
            checkWaitingTasks();
        }
    }

    private void moveTaskToAppropriateQueue(TaskObject task, TaskObject.State state) {
        switch (state) {
            case READY:
                readyQueue.add(task);
                break;
            case WAITING:
                waitingQueue.add(task);
                break;
            case DONE:
                doneQueue.add(task);
                break;
        }
    }

    private void checkWaitingTasks() {
        // This is a placeholder for whatever method you have to
        // determine if tasks in the WAITING queue are now ready.
        Queue<TaskObject> stillWaiting = new LinkedList<>();
        while (!waitingQueue.isEmpty()) {
            TaskObject task = waitingQueue.poll();
            TaskObject.State state = task.getState(); // Check external status here
            if (state == TaskObject.State.READY) {
                moveTaskToAppropriateQueue(task, TaskObject.State.READY);
            } else {
                stillWaiting.add(task); // Still waiting
            }
        }
        waitingQueue.addAll(stillWaiting);
    }

    public static void main(String[] args) {
        // Initialize some tasks
        TaskObject[] tasks = { new TaskObject(), new TaskObject(), new TaskObject() };
        // Create a WorkflowScheduler and process the tasks
        WorkflowScheduler scheduler = new WorkflowScheduler(tasks);
        scheduler.process();
    }
}

// Definition of TaskObject class
class TaskObject {
    public enum State {
        READY,
        WAITING,
        DONE
    }

    private State state;

    public TaskObject() {
        state = State.READY;
    }

    public State executeStep() {
        // Placeholder implementation: change state to DONE for simplicity
        if (state == State.READY) {
            state = State.DONE;
        } else if (state == State.WAITING) {
            state = State.READY;
        }
        return state;
    }

    public State getState() {
        return state;
    }
}