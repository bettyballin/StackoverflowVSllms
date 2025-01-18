public class ExampleMonitorClass {
    private boolean someCondition;

    public synchronized void methodRequiringExclusiveAccess() throws InterruptedException {
        while (someCondition) {
            wait();    // Releases lock on this object and suspends execution of thread till somebody calls notify() or notifyAll().
        }
        // code inside critical section...
    }
}