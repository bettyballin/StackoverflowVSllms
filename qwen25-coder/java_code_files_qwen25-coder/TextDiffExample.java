import java.util.Arrays;
import java.util.List;

import com.github.difflib.DiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;

public class TextDiffExample {
    public static void main(String[] args) throws Exception {
        String originalText = "The quick brown  fox jumped over the  lazy     dog.";
        String modifiedText = "The quick yellow fox jumped over the well-bred dog.";

        // Split the text into words for comparison
        List<String> originalWords = Arrays.asList(originalText.split("\\s+"));
        List<String> modifiedWords = Arrays.asList(modifiedText.split("\\s+"));

        Patch<String> patch = DiffUtils.diff(originalWords, modifiedWords);

        for (AbstractDelta<String> delta : patch.getDeltas()) {
            System.out.println(delta);
        }
    }
}