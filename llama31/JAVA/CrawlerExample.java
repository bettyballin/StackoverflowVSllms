import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotsTxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotsTxtServer;

public class CrawlerExample {
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "/path/to/crawl/root"; // Change this to a valid path
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setRespectRobotsTxt(true);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotsTxtConfig robotsTxtConfig = new RobotsTxtConfig();
        RobotsTxtServer robotsTxtServer = new RobotsTxtServer(robotsTxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotsTxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the URLs where you
         * want your crawl to start. In this case, we are starting with a URL that was
         * discovered in a previous crawl.
         */
        controller.addSeed("http://www.example.com");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(MyCrawler.class, numberOfCrawlers);
    }
}

class MyCrawler extends WebCrawler {
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        // Ignore the url if it has an extension that matches our defined set of image extensions.
        if (href.contains(".jpeg") || href.contains(".jpg")) {
            return false;
        }

        return true;
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            List<WebURL> links = htmlParseData.getOutgoingUrls();

            System.out.println("Text length: " + text.length());
            System.out.println("Html length: " + html.length());
            System.out.println("Number of outgoing links: " + links.size());
        }
    }
}