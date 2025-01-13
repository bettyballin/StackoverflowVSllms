import com.xuggle.mediatool.MediaReader;
import com.xuggle.mediatool.MediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.mediatool.event.IEvent;
import com.xuggle.mediatool.event.VideoEvent;

public class Mp3Converter {
    public static void main(String[] args) {
        MediaReader reader = ToolFactory.makeReader("input.wav");
        MediaWriter writer = ToolFactory.makeWriter("output.mp3");

        while (reader.hasMoreEvents()) {
            IEvent event = reader.nextEvent();
            if (event instanceof VideoEvent) {
                continue;
            }
            writer.encodeAudio(0, event);
        }
        writer.close(); // close the writer to ensure the output file is properly finalized
    }
}