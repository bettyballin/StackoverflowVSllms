import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlTableRenderer {
    public static void main(String[] args) throws IOException {
        String html = "<table><tr><td>Hello</td><td>World!</td></tr></table>";
        Document doc = Jsoup.parse(html);
        Element table = doc.select("table").first();

        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // Draw table background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight());

        // Draw table rows and cells
        Elements rows = table.select("tr");
        int rowHeight = 20;
        int cellWidth = 100;
        int x = 10;
        int y = 10;
        for (Element row : rows) {
            Elements cells = row.select("td");
            for (Element cell : cells) {
                String cellText = cell.text();
                g2d.setColor(Color.BLACK);
                g2d.drawString(cellText, x, y + rowHeight);
                x += cellWidth;
            }
            x = 10;
            y += rowHeight;
        }

        // Save image to file
        g2d.dispose();
        ImageIO.write(image, "png", new File("table.png"));
    }
}