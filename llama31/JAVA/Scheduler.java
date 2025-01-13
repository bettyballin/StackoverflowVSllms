import java.util.concurrent.ConcurrentLinkedQueue;

// Define the State enum
enum State {
    READY,
    WAITING,
    DONE
}

// Define the TaskObject class
class TaskObject {
    private State state;

    public State executeStep() {
        // TO DO: implement the executeStep method
        return State.DONE; // default implementation
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

public class Scheduler {
    private ConcurrentLinkedQueue<TaskObject> readyQueue;
    private ConcurrentLinkedQueue<TaskObject> waitingQueue;
    private ConcurrentLinkedQueue<TaskObject> doneQueue;

    public Scheduler() {
        readyQueue = new ConcurrentLinkedQueue<>();
        waitingQueue = new ConcurrentLinkedQueue<>();
        doneQueue = new ConcurrentLinkedQueue<>();
    }

    public void schedule(TaskObject obj) {
        readyQueue.add(obj);
    }

    public void run() {
        while (!readyQueue.isEmpty()) {
            TaskObject obj = readyQueue.poll();
            State state = obj.executeStep();
            switch (state) {
                case READY:
                    readyQueue.add(obj);
                    break;
                case WAITING:
                    waitingQueue.add(obj);
                    break;
                case DONE:
                    doneQueue.add(obj);
                    break;
            }
        }
    }

    // Callback method for objects in the WAITING queue
    public void onStateChange(TaskObject obj) {
        if (obj.getState() == State.READY) {
            waitingQueue.remove(obj);
            readyQueue.add(obj);
        } else if (obj.getState() == State.DONE) {
            waitingQueue.remove(obj);
            doneQueue.add(obj);
        }
    }

    public static void main(String[] args) {
        // Create a new Scheduler instance
        Scheduler scheduler = new Scheduler();

        // Create a new TaskObject instance
        TaskObject task = new TaskObject();

        // Schedule the task
        scheduler.schedule(task);

        // Run the scheduler
        scheduler.run();
    }
}