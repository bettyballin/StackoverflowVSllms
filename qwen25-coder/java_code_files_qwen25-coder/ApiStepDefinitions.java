import java.lang.String;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.StringReader;
import org.xml.sax.InputSource;

// Define the Given and Then annotations
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Given {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Then {
    String value();
}

// Define the HttpClient related classes

interface CloseableHttpClient {
    CloseableHttpResponse execute(HttpGet request) throws Exception;
}

class HttpClients {
    public static CloseableHttpClient createDefault() {
        return new CloseableHttpClientImpl();
    }
}

class CloseableHttpClientImpl implements CloseableHttpClient {
    public CloseableHttpResponse execute(HttpGet request) throws Exception {
        return new CloseableHttpResponseImpl();
    }
}

interface CloseableHttpResponse {
    StatusLine getStatusLine();
    HttpEntity getEntity();
}

class CloseableHttpResponseImpl implements CloseableHttpResponse {
    public StatusLine getStatusLine() {
        return new StatusLine();
    }
    public HttpEntity getEntity() {
        return new HttpEntity();
    }
}

class HttpGet {
    public HttpGet(String url) {}
}

class StatusLine {
    public int getStatusCode() {
        return 200; // default status code
    }
}

class HttpEntity {
}

class EntityUtils {
    public static String toString(HttpEntity entity) {
        return ""; // return empty string
    }
}

public class ApiStepDefinitions {

    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private CloseableHttpResponse response;

    @Given("I call the API with {string} method and URL {string}")
    public void i_call_the_API_with_method_and_URL(String method, String url) throws Exception {
        HttpGet request = new HttpGet(url);
        response = httpClient.execute(request);
    }

    @Then("response code should be {int}")
    public void response_code_should_be(int statusCode) throws Exception {
        assert statusCode == response.getStatusLine().getStatusCode();
    }

    @Then("response should contain XML data {string} in element {string}")
    public void response_should_contain_XML_data_in_element(String expectedValue, String xPath) throws Exception {
        String responseBody = EntityUtils.toString(response.getEntity());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(responseBody)));
        org.w3c.dom.Element element = (org.w3c.dom.Element)(document.getElementsByTagNameNS(
            xPath.substring(0, xPath.indexOf("/")),
            xPath.split("/")[(xPath.split("/").length)-1]
        ).item(0));
        assert expectedValue.equals(element.getTextContent());
    }

    public static void main(String[] args) {
    }
}