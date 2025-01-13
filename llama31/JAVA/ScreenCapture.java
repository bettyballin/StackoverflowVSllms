import java.lang.String;
import java.lang.Set;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Processor;
import javax.media.ProcessorModel;
import javax.media.protocol.DataSource;
import javax.media.Buffer;

import com.xuggle.mediatool.MediaReader;
import com.xuggle.mediatool.MediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.mediatool.event.Event;
import com.xuggle.mediatool.event.IEvent;

public class ScreenCapture {
    public static void main(String[] args) {
        // Set up the screen capture
        Manager.setHint(Manager.PLATFORM, "JMF");
        MediaLocator ml = new MediaLocator("screen://0,0,1024,768");
        DataSource ds = Manager.createDataSource(ml);
        ProcessorModel pm = new ProcessorModel(ds, "screenvideo", "video");
        Processor processor = Manager.createProcessor(pm);

        // Set up the Xuggle writer
        MediaWriter writer = ToolFactory.makeWriter("output.flv");
        writer.addVideoStream(0, 0, 1024, 768);

        // Start the screen capture and encoding
        processor.start();
        while (processor.getState() != Processor.Configured) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        processor.configure();
        processor.realize();
        while (processor.getState() != Processor.Started) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Buffer buffer = new Buffer();
        while ((buffer = processor.getOutput()) != null) {
            IEvent event = new Event(buffer);
            writer.encodeVideo(0, event);
        }
        writer.close();
    }
}