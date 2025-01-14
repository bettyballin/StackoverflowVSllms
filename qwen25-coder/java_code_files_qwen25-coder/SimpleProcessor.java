import java.lang.String;
public class SimpleProcessor {
    private boolean isInstructionExecuting = false;

    public void executeInstruction(Instruction instruction) {
        if (!isInstructionExecuting) {
            isInstructionExecuting = true;
            // Simulate the time taken by this instruction
            simulateExecutionTime(instruction);
            isInstructionExecuting = false;
        } else {
            System.out.println("An instruction is already executing. Please wait.");
        }
    }

    private void simulateExecutionTime(Instruction instruction) {
        try {
            Thread.sleep(instruction.getExecutionTimeInMs());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Execution was interrupted");
        }
    }
}

class Instruction {
    private int executionTimeInMs;

    public Instruction(int executionTimeInMs) {
        this.executionTimeInMs = executionTimeInMs;
    }

    public int getExecutionTimeInMs() {
        return executionTimeInMs;
    }

	public static void main(String[] args) {
	}
}