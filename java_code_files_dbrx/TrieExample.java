import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class TrieExample {
    private final Interner<String> interner = Interners.newWeakInterner();
    public void doSomething() {
        Map<String, Object> trieBasedMap = new TreeMap<>((String left, String right) -> interner.intern(left).compareTo(interner.intern(right)));
        // add elements to trieBasedMap here...
    }

    public static void main(String[] args) {
    }
}