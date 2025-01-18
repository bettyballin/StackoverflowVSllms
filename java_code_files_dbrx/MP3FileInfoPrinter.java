import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import java.io.File;

public class MP3FileInfoPrinter {

    public static void printMP3FileInfo(String filename) throws Exception {
        AudioFile audioFile = AudioFileIO.read(new File(filename)); // reads the file into the jaudiotagger object

        Tag tag = audioFile.getTag();

        String artistName = tag.getFirst(FieldKey.ARTIST); // Gets artist tag value from metadata of song
        System.out.println("Artist : " + artistName);

        String albumTitle = tag.getFirst(FieldKey.ALBUM); // Get Album name from metadata of song
        System.out.println("Album : " + albumTitle);
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java MP3FileInfoPrinter <mp3-file>");
            return;
        }

        printMP3FileInfo(args[0]);
    }
}