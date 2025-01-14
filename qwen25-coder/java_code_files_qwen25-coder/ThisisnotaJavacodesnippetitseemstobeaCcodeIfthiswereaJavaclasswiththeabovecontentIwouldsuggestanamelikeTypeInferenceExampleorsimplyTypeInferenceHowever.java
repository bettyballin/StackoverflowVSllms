import java.lang.String;
import java.util.*;

public class ThisisnotaJavacodesnippetitseemstobeaCcodeIfthiswereaJavaclasswiththeabovecontentIwouldsuggestanamelikeTypeInferenceExampleorsimplyTypeInferenceHowever {

    Object myObject = createEmptyList(); // This works but T is inferred as Object

    // Or explicitly specify the type parameter if needed:
    Object myListOfIntegers = createEmptyList();

    public static void main(String[] args) {
    }

    public static <T> List<T> createEmptyList() {
        return new ArrayList<T>();
    }
}