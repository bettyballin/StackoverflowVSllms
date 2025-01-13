import java.lang.String;
import quicktime.QTSession;
import quicktime.player.Player;

public class DRMTTest {
    public static void main(String[] args) {
        QTSession.open();
        Player player = new Player();
        
        // Attempt to play an iTunes DRM-protected movie
        String moviePath = "/path/to/itunes/drm/movie.m4v";
        try {
            player.setMovie(moviePath);
            player.play();
        } catch (Exception e) {
            System.out.println("Error playing movie: " + e.getMessage());
        }
        
        QTSession.close();
    }
}