import java.util.Set;
import java.lang.String;
import java.util.HashSet;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.people.PeopleInterface;
import com.flickr4java.flickr.people.User;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.Photo;

public class UserPhotosFetcher {
    public static void main(String[] args) {
        // First, initialize your Flickr instance with API key and secret
        String apiKey = "API_KEY";
        String secret = "SECRET";
        Flickr flickr = new Flickr(apiKey, secret, new REST());

        // Get Interfaces
        PeopleInterface peopleIF = flickr.getPeopleInterface();
        PhotosInterface photosIF = flickr.getPhotosInterface();

        // Find user by username or ID
        String username = "USERNAME_HERE"; // Define the username
        User u = null;
        try {
            u = peopleIF.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Set Extras parameters (optional)
        Set<String> extras = new HashSet<String>();
        extras.add("tags");
        extras.add("description");
        // You can add more like ("url_m", "date_upload") parameters as per your requirement.

        // Get photos of a user sorted by default sort order
        PhotoList<Photo> photoList = null;
        try {
            photoList = photosIF.getPhotos(u.getId(), extras, 100, 1);
            for (int i = 0; i < photoList.size(); i++) {
                Photo photoObject = (Photo) photoList.get(i);
                String imageUrl = photoObject.getMedium800Url(); // You can replace medium size URL with url_m, thumbnail etc. as per your requirement.
                System.out.println(imageUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}