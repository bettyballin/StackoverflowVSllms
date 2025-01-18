import org.springframework.util.Base64Utils;

public class ImageToBase64Converter {
    public static void main(String[] args) {
        byte[] imageBytes = {}; // Initialize with your Byte[] data
        String imageMimeType = "image/jpeg"; // Replace with the actual MIME type

        String base64Image = Base64Utils.encodeToString(imageBytes); // imageBytes is your Byte[]
        String mimeType = "data:" + imageMimeType + ";base64,"; // assuming you have the MIME type of the image available, otherwise hardcode to a suitable format like 'image/jpeg' or 'image/png'.

        // You can now use base64Image and mimeType as needed
    }
}