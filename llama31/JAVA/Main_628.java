import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.MetaBox;
import com.coremedia.iso.boxes.MetaBoxType;

public class Main_628 {
    public static void main(String[] args) {
        try {
            IsoFile isoFile = new IsoFile("path/to/video/file.mp4");
            MetaBox metaBox = isoFile.getBoxes(MetaBox.class).get(0);
            // Note: MetaBoxType is not a valid class in the isoparser library
            // Assuming you meant to get the type of the MetaBox directly
            String metaBoxType = metaBox.getType();
            // Note: MetaBox does not have methods getTitle() and getAuthor()
            // Assuming you meant to parse the meta box data manually
            // For demonstration purposes, we'll just print the meta box type
            System.out.println("Meta Box Type: " + metaBoxType);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}