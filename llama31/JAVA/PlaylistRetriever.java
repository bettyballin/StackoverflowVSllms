import java.io.IOException;
import java.net.URL;

import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.VideoFeed;

public class PlaylistRetriever {
  public static void main(String[] args) throws IOException {
    YouTubeService service = new YouTubeService("your-app-id");
    URL feedUrl = new URL("http://gdata.youtube.com/feeds/api/playlists/[feed-id]");

    VideoFeed feed = service.getFeed(feedUrl, VideoFeed.class);

    int startIndex = 1;
    while (feed.getEntries().size() > 0) {
      System.out.println("Retrieved " + feed.getEntries().size() + " entries");

      // Process the entries...

      // Get the next set of entries
      startIndex += 25;
      feedUrl = new URL("http://gdata.youtube.com/feeds/api/playlists/[feed-id]?start-index=" + startIndex + "&max-results=25");
      feed = service.getFeed(feedUrl, VideoFeed.class);
    }
  }
}