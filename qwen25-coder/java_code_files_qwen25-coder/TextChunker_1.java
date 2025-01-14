public class TextChunker_1 {

    private static final int LINES_PER_PAGE = 4;
    private static final int CHARS_PER_LINE = 20;

    public String[] chunkText(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split("\\s+");
        int currentLineLength = 0;
        int lineCount = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > CHARS_PER_LINE) {
                // Handle very long words
                while (word.length() > CHARS_PER_LINE) {
                    result.append(word.substring(0, CHARS_PER_LINE - 1)).append('-').append('\n');
                    lineCount++;
                    currentLineLength = 0;
                    word = word.substring(CHARS_PER_LINE - 1);
                }
            }

            if (currentLineLength + word.length() > CHARS_PER_LINE) {
                // Newline needed
                result.append('\n');
                currentLineLength = 0;
                lineCount++;
            } else if (currentLineLength > 0 && lineCount % LINES_PER_PAGE == 0) {
                // New page needed
                result.append('\f'); // Form feed to indicate a new page
                currentLineLength = 0;
                lineCount = 0;
            }

            if (currentLineLength > 0) {
                result.append(' ');
                currentLineLength++;
            }
            
            result.append(word);
            currentLineLength += word.length();
        }

        // Split into pages
        return result.toString().split("\f");
    }

    public static void main(String[] args) {
        TextChunker_1 chunker = new TextChunker_1();
        String text = "This is an example of a long piece of text that needs to be split into chunks for display on a 4x20 LCD screen. This text includes verylongwords that should be handled appropriately.";
        String[] pages = chunker.chunkText(text);

        for (int i = 0; i < pages.length; i++) {
            System.out.println("Page " + (i + 1) + ":");
            System.out.println(pages[i]);
        }
    }
}