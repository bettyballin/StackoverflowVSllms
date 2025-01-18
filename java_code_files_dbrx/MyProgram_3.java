import java.io.*;

public class MyProgram {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("expected one argument");
            System.exit(1);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            int count = 0;
            String lastTag = "";

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                if (tokens.length > 0) {
                    String tag = tokens[0];
                    if (lastTag.isEmpty()) {
                        lastTag = tag;
                        count = 1;
                    } else if (tag.equals(lastTag)) {
                        count++;
                    } else {
                        System.out.println(lastTag + " " + count);
                        lastTag = tag;
                        count = 1;
                    }
                }
            }
            // Print the remaining count for the last tag.
            System.out.println(lastTag + " " + count);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}