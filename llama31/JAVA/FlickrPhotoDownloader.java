import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photosets.Photoset;
import com.flickr4java.flickr.photosets.PhotosetsInterface;
import com.flickr4java.flickr.people.User;

public class FlickrPhotoDownloader {
    private static final String KEY = "YOUR_API_KEY";
    private static final String SECRET = "YOUR_API_SECRET";
    private static final String USERNAME = "username";
    private static final String PATH = "path/to/file/";

    public static void main(String[] args) throws Exception {
        Transport t = new REST();
        Flickr f = new Flickr(KEY, SECRET, t);
        User u = f.getPeopleInterface().findByUsername(USERNAME);

        // Get the user's photosets
        PhotosetsInterface photosetsInterface = f.getPhotosetsInterface();
        List<Photoset> photosets = photosetsInterface.getPhotosets(u.getId(), 0, 0);

        // Loop through each photoset
        for (Photoset photoset : photosets) {
            // Get the photos in the photoset
            PhotoList photos = photosetsInterface.getPhotos(photoset.getId(), 0, 0);

            // Loop through each photo
            for (Photo photo : photos) {
                // Get the photo URL
                String url = f.getPhotosInterface().getPhotoUrl(photo.getId(), Photo.SIZE_LARGE);

                // Download the photo and save it to a file
                InputStream in = new URL(url).openStream();
                File file = new File(PATH + photo.getFilename());
                OutputStream out = new FileOutputStream(file);
                IOUtils.copy(in, out);
                in.close();
                out.close();
            }
        }
    }
}