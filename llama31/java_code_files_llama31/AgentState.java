/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AgentState {
    private static final String STATE_FILE = "agent_state.json";

    public static void saveState(String string) throws IOException {
        try (FileWriter fileWriter = new FileWriter(STATE_FILE);){
            fileWriter.write(string);
        }
    }

    public static String loadState() throws IOException {
        try (FileReader fileReader = new FileReader(STATE_FILE);){
            char[] cArray = new char[1024];
            int n = fileReader.read(cArray);
            String string = new String(cArray, 0, n);
            return string;
        }
    }

    public static void main(String[] stringArray) {
    }
}
