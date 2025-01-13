import java.util.List;
import java.util.ArrayList;

public class TextChunker {
    private static final int LINE_LENGTH = 20;
    private static final int LINES_PER_PAGE = 4;

    public static List<String> chunkText(String text) {
        List<String> pages = new ArrayList<>();
        StringBuilder currentPage = new StringBuilder();

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (currentPage.length() + word.length() + 1 > LINE_LENGTH * LINES_PER_PAGE) {
                // Add current page to list and reset
                pages.add(currentPage.toString());
                currentPage = new StringBuilder();
            }

            if (currentPage.length() % LINE_LENGTH == 0 && currentPage.length() != 0) {
                // Start of a new line, avoid leading space
                currentPage.append("\n");
            }

            if (word.length() > LINE_LENGTH) {
                // Very long word, break it across lines
                int chunkSize = LINE_LENGTH - (currentPage.length() % LINE_LENGTH);
                while (word.length() > chunkSize) {
                    currentPage.append(word.substring(0, chunkSize)).append("-\n");
                    word = word.substring(chunkSize);
                    chunkSize = LINE_LENGTH;
                }
                currentPage.append(word);
            } else if (currentPage.length() % LINE_LENGTH + word.length() > LINE_LENGTH) {
                // Word doesn't fit on current line, break and add hyphen
                int spaceLeft = LINE_LENGTH - (currentPage.length() % LINE_LENGTH);
                currentPage.append(word.substring(0, spaceLeft)).append("-\n");
                currentPage.append(word.substring(spaceLeft));
            } else {
                // Word fits on current line, just append
                if (currentPage.length() != 0) {
                    currentPage.append(" ");
                }
                currentPage.append(word);
            }
        }

        // Add last page to list
        pages.add(currentPage.toString());

        return pages;
    }

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        List<String> pages = chunkText(text);
        for (int i = 0; i < pages.size(); i++) {
            System.out.println("Page " + (i + 1) + ":\n" + pages.get(i) + "\n");
        }
    }
}