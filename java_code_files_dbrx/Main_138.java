import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    public static void main(String[] args) {
        try {
            File soundFile = new File("Sample.wav"); // Path to your WAV file
            AudioInputStream audioInstr = AudioSystem.getAudioInputStream(soundFile); // Get audio input stream from file

            // You can add code here to play the audio or process it as needed
            AudioFormat format = audioInstr.getFormat();
            System.out.println("Audio Format: " + format.toString());

            // Don't forget to close the AudioInputStream when done
            audioInstr.close();
        } catch (UnsupportedAudioFileException e) {
            System.err.println("The specified audio file is not supported.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error occurred while accessing the audio file.");
            e.printStackTrace();
        }
    }
}