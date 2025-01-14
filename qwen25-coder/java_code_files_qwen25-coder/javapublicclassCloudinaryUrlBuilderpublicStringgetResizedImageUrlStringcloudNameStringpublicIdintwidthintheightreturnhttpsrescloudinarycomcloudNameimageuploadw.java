public class CloudinaryUrlBuilder {
    // Example Java code snippet to construct a resized image URL using Cloudinary
    public String getResizedImageUrl(String cloudName, String publicId, int width, int height) {
        return "https://res.cloudinary.com/" + cloudName + "/image/upload/w_" +
               width + ",h_" + height + "/" + publicId + ".jpg";
    }
    public static void main(String[] args) {
    }
}