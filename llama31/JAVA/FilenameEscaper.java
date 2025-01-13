public class FilenameEscaper {
    public static void main(String[] args) {
        String filename = "example--file.txt";
        String escapedFilename = filename.replace("--", "-&#45;");

        // Output the escaped filename inside the comment tag
        System.out.println("<!-- " + escapedFilename + " -->");
    }
}