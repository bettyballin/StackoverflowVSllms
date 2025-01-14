import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/jars/PublicJar.jar")
public class JarServlet extends HttpServlet {
    private static final String JAR_FILE_PATH = "/WEB-INF/lib/PublicJar.jar";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type and headers for the jar file
        response.setContentType("application/java-archive");
        response.setHeader("Content-Disposition", "attachment; filename=PublicJar.jar");

        // Get real path of the JAR file inside the WAR
        String realPath = getServletContext().getRealPath(JAR_FILE_PATH);

        // Stream the JAR file to the client
        try (FileInputStream fis = new FileInputStream(realPath);
             ServletOutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
        }
    }

    public static String computeSHA256(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        try (DigestInputStream dis = new DigestInputStream(new FileInputStream(file), digest)) {
            while (dis.read() != -1); // Read until EOF
        }
        byte[] hashBytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        // Example usage of computeSHA256
        File jarFile = new File("path/to/WEB-INF/lib/PublicJar.jar");
        String hash = computeSHA256(jarFile);
        System.out.println("SHA-256 of the JAR file: " + hash);
    }
}