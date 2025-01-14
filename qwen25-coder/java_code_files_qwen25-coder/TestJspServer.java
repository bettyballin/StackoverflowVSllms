import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class TestJspServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setResourceBase("src/main/webapp"); // path to your JSP files
        webAppContext.getServletContext().setAttribute("testData", mockDataService()); // setting an attribute to simulate data injection

        server.setHandler(webAppContext);

        server.start();
        server.join();
    }

    private static Object mockDataService() {
        // return some mock data structure here
        return new YourMockData(); 
    }

    static class YourMockData {
        // mock implementation
    }
}