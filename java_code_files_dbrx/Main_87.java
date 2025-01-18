import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;
import java.util.function.*;
import static java.lang.Integer.parseInt;

public class Main_87 {
    private static final Map<Integer, String> photos = new HashMap<>(); // initialize this accordingly

    private static Function<MatchResult, String> thumbReplace
        = match -> "<img src=\"thumbnails/" + photos.get(parseInt(match.group(1))) + "\"/>";

    public static void main(String[] args) {
        final var pattern = Pattern.compile("\\[thumb(\\d+)]");
        String articleText = "your article text... [thumb50]..."; // initialize this accordingly

        articleText = pattern.matcher(articleText).replaceAll(thumbReplace);
    }
}