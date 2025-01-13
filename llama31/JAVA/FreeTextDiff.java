import java.util.List;

import com.github.difflib.DiffRow;
import com.github.difflib.DiffRowGenerator;
import com.google.common.collect.Lists;

public class FreeTextDiff {
    public static void main(String[] args) {
        String text1 = "The quick brown  fox jumped over the  lazy     dog.";
        String text2 = "The quick yellow fox jumped over the well-bred dog.";

        DiffRowGenerator generator = DiffRowGenerator.create()
                .showInlineDiffs(true)
                .inlineDiffByWord(true)
                .oldTag(f -> "~") // optional
                .newTag(f -> "**") // optional
                .build();

        List<DiffRow> rows = generator.generateDiffRows(
                Lists.newArrayList(text1),
                Lists.newArrayList(text2));

        for (DiffRow row : rows) {
            System.out.println(row.getTag() + " " + row.getOldLine());
            System.out.println(row.getTag() + " " + row.getNewLine());
        }
    }
}