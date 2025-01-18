import android.media.MediaMetadataRetriever;

public class FrameExtractor {
    public String extractFrame(String filePath) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            retriever.setDataSource(filePath); // The path of the video to be loaded
            return String.valueOf(retriever.getFrameAtTime(-1, MediaMetadataRetriever.OPTION_CLOSEST) != null);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return "false";
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
               // Ignore failures while cleaning up.
            }
        }
    }
}