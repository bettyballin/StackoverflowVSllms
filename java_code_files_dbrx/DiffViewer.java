import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class DiffViewer {

    public static void main(String[] args) {

        diff_match_patch dmp = new diff_match_patch();

        List<String> originalTextLines = Arrays.asList("Hello", "this is the sample text.");

        List<String> modifiedTextLines = Arrays.asList("Hellooo", "this is a changed text.");

        String originalText = String.join("\n", originalTextLines);

        String modifiedText = String.join("\n", modifiedTextLines);

        LinkedList<diff_match_patch.Diff> diffList = dmp.diff_main(originalText, modifiedText, false);

        System.out.println("Differences: ");

        for (diff_match_patch.Diff aDiff : diffList) {

            System.out.print(aDiff.operation + ": " + aDiff.text);

        }

    }

}