// File: src/main/java/org/myhypotheticalwrapper/MyApp_2.java
package org.myhypotheticalwrapper;
import org.myhypotheticalwrapper.analyzer.*; // Import the necessary classes for each API version

public class MyApp_2 {
  private Worker workerV1 = new WorkerV1();
  private Worker workerV2 = new WorkerV2();

	public static void main(String[] args) {
	}
}

// File: src/main/java/org/myhypotheticalwrapper/analyzer/Worker.java
package org.myhypotheticalwrapper.analyzer;

public interface Worker {
    // Interface methods
}

// File: src/main/java/org/myhypotheticalwrapper/analyzer/WorkerV1.java
package org.myhypotheticalwrapper.analyzer;

public class WorkerV1 implements Worker {
    public WorkerV1() {}
}

// File: src/main/java/org/myhypotheticalwrapper/analyzer/WorkerV2.java
package org.myhypotheticalwrapper.analyzer;

public class WorkerV2 implements Worker {
    public WorkerV2() {}
}