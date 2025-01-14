import java.lang.String;
import java.io.*;

public class AgentState {
    private static final String FILE_NAME = "agent-state.txt";

    public void saveState(String state) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(state);
        }
    }

    public String loadState() throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString().trim();
    }

    public static void main(String[] args) {
        AgentState agent = new AgentState();
        try {
            // Save some state
            agent.saveState("Performance: Excellent");

            // Load the state
            String loadedState = agent.loadState();
            System.out.println("Loaded State: " + loadedState);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}