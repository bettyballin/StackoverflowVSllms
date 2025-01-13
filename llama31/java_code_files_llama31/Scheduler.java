/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentLinkedQueue;

public class Scheduler {
    private ConcurrentLinkedQueue<TaskObject> readyQueue = new ConcurrentLinkedQueue();
    private ConcurrentLinkedQueue<TaskObject> waitingQueue = new ConcurrentLinkedQueue();
    private ConcurrentLinkedQueue<TaskObject> doneQueue = new ConcurrentLinkedQueue();

    public void schedule(TaskObject taskObject) {
        this.readyQueue.add(taskObject);
    }

    public void run() {
        while (!this.readyQueue.isEmpty()) {
            TaskObject taskObject = this.readyQueue.poll();
            State state = taskObject.executeStep();
            switch (state) {
                case READY: {
                    this.readyQueue.add(taskObject);
                    break;
                }
                case WAITING: {
                    this.waitingQueue.add(taskObject);
                    break;
                }
                case DONE: {
                    this.doneQueue.add(taskObject);
                }
            }
        }
    }

    public void onStateChange(TaskObject taskObject) {
        if (taskObject.getState() == State.READY) {
            this.waitingQueue.remove(taskObject);
            this.readyQueue.add(taskObject);
        } else if (taskObject.getState() == State.DONE) {
            this.waitingQueue.remove(taskObject);
            this.doneQueue.add(taskObject);
        }
    }

    public static void main(String[] stringArray) {
        Scheduler scheduler = new Scheduler();
        TaskObject taskObject = new TaskObject();
        scheduler.schedule(taskObject);
        scheduler.run();
    }
}
