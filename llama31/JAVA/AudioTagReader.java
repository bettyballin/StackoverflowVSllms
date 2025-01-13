import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import java.io.File;

public class AudioTagReader {
    public static void main(String[] args) {
        try {
            AudioFile audioFile = AudioFileIO.read(new File("path/to/audio/file.mp3"));
            Tag tag = audioFile.getTag();
            String artist = tag.getFirst(FieldKey.ARTIST);
            String title = tag.getFirst(FieldKey.TITLE);
            System.out.println("Artist: " + artist);
            System.out.println("Title: " + title);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}