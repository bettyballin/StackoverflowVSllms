interface WorkerStrategy {
    Object connectAndDoStuff();
}

class OldWorker implements WorkerStrategy {
    // Use old API
    @Override
    public Object connectAndDoStuff() {
        // Simulate old API work
        System.out.println("OldWorker: Connecting and doing stuff using old API.");
        return new Object(); // Return some object
    }
}

class NewWorker implements WorkerStrategy {
    // Use new API
    @Override
    public Object connectAndDoStuff() {
        // Simulate new API work
        System.out.println("NewWorker: Connecting and doing stuff using new API.");
        return new Object(); // Return some object
    }
}

class Comparator {
    private Object obj1;
    private Object obj2;

    public Comparator(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void generateReport() {
        // Simulate generating a report
        System.out.println("Comparator: Generating report comparing obj1 and obj2.");
    }
}

class Analyzer {
    private WorkerStrategy w1;
    private WorkerStrategy w2;

    public Analyzer(WorkerStrategy oldWorker, WorkerStrategy newWorker) {
        this.w1 = oldWorker;
        this.w2 = newWorker;
    }

    public void analyze() {
        Comparator c = new Comparator(w1.connectAndDoStuff(), w2.connectAndDoStuff());
        c.generateReport();
    }
}

public class Main {
    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer(new OldWorker(), new NewWorker());
        analyzer.analyze();
    }
}