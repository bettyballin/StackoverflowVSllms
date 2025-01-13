import java.lang.String;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AgentState {
    private static final String STATE_FILE = "agent_state.json";

    public static void saveState(String state) throws IOException {
        try (FileWriter writer = new FileWriter(STATE_FILE)) {
            writer.write(state);
        }
    }

    public static String loadState() throws IOException {
        try (FileReader reader = new FileReader(STATE_FILE)) {
            char[] buffer = new char[1024];
            int bytesRead = reader.read(buffer);
            return new String(buffer, 0, bytesRead);
        }
    }

	public static void main(String[] args) {
	}
}