import java.io.File;

// Note: The javazoom.jl.converter package is not part of the standard Java API.
// You need to download the JLayer library from http://www.javazoom.net/javalayer/sources.html
// and add the jl1.0.1.jar file to your classpath.

import javazoom.jl.converter.Converter;

public class Mp3Converter_1_1 {
    public static void main(String[] args) {
        Converter converter = new Converter();
        File inputFile = new File("input.wav");
        File outputFile = new File("output.mp3");
        converter.convert(inputFile, outputFile);
    }
}