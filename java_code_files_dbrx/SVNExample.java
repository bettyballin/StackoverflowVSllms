import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;

public class SVNExample {
    public static void main(String[] args) throws Exception {
        String svnRepoUrl = "https://subversion.server/svn/repo";
        URL repoUrl = new URL(svnRepoUrl);
        HttpURLConnection con = (HttpURLConnection) repoUrl.openConnection();
        con.setRequestMethod("REPORT");
        con.setRequestProperty("Depth", "1");  // change according to your needs
        InputStream svnResponse = con.getInputStream();  // XML response containing the metadata you need

        // Optionally, process the response
        // For example, read and print the response
        int c;
        while ((c = svnResponse.read()) != -1) {
            System.out.print((char) c);
        }
        svnResponse.close();
    }
}