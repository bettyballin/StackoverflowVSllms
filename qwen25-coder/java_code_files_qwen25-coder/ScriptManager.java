import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class ScriptManager {
    private static final Set<String> includedScripts = Collections.synchronizedSet(new HashSet<>());

    public static void addScript(String scriptName) {
        includedScripts.add(scriptName);
    }

    public static boolean isScriptIncluded(String scriptName) {
        return includedScripts.contains(scriptName);
    }

    public static void main(String[] args) {
    }
}