public class TextPageFormatter {
    public static void main(String[] args) {
        String text = "Your long arbitrary text goes here.";
        int lineLength = 20; // 20 characters per line
        boolean wrapLongWords = true; // break long words at character boundaries if necessary
        String newLineStr = "\n"; // or "\r\n" for Windows compatibility.

        StringBuilder formattedTextBuilder = new StringBuilder();
        String[] lines = text.split(newLineStr);
        for (String line : lines) {
            // Wrap each input line into a single "page"
            String page = WordUtils.wrap(line, lineLength, newLineStr, wrapLongWords);
            formattedTextBuilder.append(page).append("\n");
        }

        String formattedText = formattedTextBuilder.toString();
        // Print the output text in a 4x20 format.
        System.out.println("Output:\n" + formattedText);
    }
}

class WordUtils {
    public static String wrap(String str, int wrapLength, String newLineStr, boolean wrapLongWords) {
        if (str == null) {
            return null;
        }
        if (newLineStr == null) {
            newLineStr = System.lineSeparator();
        }
        if (wrapLength < 1) {
            wrapLength = 1;
        }
        int inputLineLength = str.length();
        int offset = 0;
        StringBuilder wrappedLine = new StringBuilder(inputLineLength + 32);

        while ((inputLineLength - offset) > wrapLength) {
            if (str.charAt(offset) == ' ') {
                offset++;
                continue;
            }
            int spaceToWrapAt = str.lastIndexOf(' ', wrapLength + offset);

            if (spaceToWrapAt >= offset) {
                // normal case
                wrappedLine.append(str.substring(offset, spaceToWrapAt));
                wrappedLine.append(newLineStr);
                offset = spaceToWrapAt + 1;
            } else {
                // no space found
                if (wrapLongWords) {
                    // wrap really long word
                    wrappedLine.append(str.substring(offset, wrapLength + offset));
                    wrappedLine.append(newLineStr);
                    offset += wrapLength;
                } else {
                    // do not wrap long words, so go to next space
                    spaceToWrapAt = str.indexOf(' ', wrapLength + offset);
                    if (spaceToWrapAt >= 0) {
                        wrappedLine.append(str.substring(offset, spaceToWrapAt));
                        wrappedLine.append(newLineStr);
                        offset = spaceToWrapAt + 1;
                    } else {
                        // last resort
                        wrappedLine.append(str.substring(offset));
                        offset = inputLineLength;
                    }
                }
            }
        }

        // Whatever is left in line is less than wrapLength
        wrappedLine.append(str.substring(offset));

        return wrappedLine.toString();
    }
}