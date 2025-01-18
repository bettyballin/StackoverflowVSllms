import com.xuggle.mediatool.ToolFactory;	
import com.xuggle.mediatool.MediaToolAdapter;	
import com.xuggle.mediatool.event.IVideoPictureEvent;

public class MetadataExtractor extends MediaToolAdapter { 
    private boolean gotMetadata = false;

    public void onVideoPicture(IVideoPictureEvent event) {
        if (!gotMetadata) {
            String metadata = ToolFactory.makeMetaDataTool().processFile(event.getSource().getUrl()); // extracts the metadata from video file
            System.out.println("metadata: " + metadata);
            gotMetadata = true; 
        }
        super.onVideoPicture(event);
    }

    // In main Method, create a new instance of MetadataExtractor and pass it to MediaViewer or any other media playing tool created by Xuggle
    public static void main(String[] args) {
        // Example usage:
        MetadataExtractor extractor = new MetadataExtractor();
        String mediaFile = "path/to/media/file"; // Replace with the actual media file path
        com.xuggle.mediatool.IMediaReader mediaReader = ToolFactory.makeReader(mediaFile);
        mediaReader.addListener(extractor);

        while (mediaReader.readPacket() == null) {
            // Reading packets
        }
    }
}