import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.mail.HtmlEmail;

import java.io.StringWriter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EmailTemplateService {
    private Configuration config;

    public EmailTemplateService(String templatePath) throws Exception {
        // Initialize the Freemarker configuration
        config = new Configuration(Configuration.VERSION_2_3_31);
        config.setDirectoryForTemplateLoading(new File(templatePath));
        config.setDefaultEncoding("UTF-8");
    }

    public void sendEmail(String to, String subject, Map<String, Object> data) throws Exception {
        // Load the HTML template
        Template htmlTemplate = config.getTemplate("email-template.html");

        // Prepare the data model for your email content
        data.put("imagesDir", "path/to/images"); // Assuming you have a way to reference images

        // Create writer and process template into HTML format
        StringWriter outHtml = new StringWriter();
        htmlTemplate.process(data, outHtml);

        // Optionally convert HTML to plain text (basic conversion)
        String htmlContent = outHtml.toString();
        String plainTextContent = HtmlToPlainTextConverter.convert(htmlContent); // Implement a converter

        // Create email message
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.example.com");
        email.addTo(to);
        email.setFrom("no-reply@example.com", "Example");
        email.setSubject(subject);

        // Set HTML and text versions of the email
        email.setHtmlMsg(outHtml.toString());
        email.setTextMsg(plainTextContent);

        // Embed images (if any)
        boolean hasImages = false;
        // Logic to attach images goes here
        if (hasImages) {
            // Example: String cid = email.embed(new File("path/to/image.png"), "test image");
            // You would need a mechanism to identify and include images in your data model
        }

        // Send the email
        email.send();
    }

    public static void main(String[] args) {
    }
}

// Implement a simple HtmlToPlainTextConverter
class HtmlToPlainTextConverter {
    public static String convert(String html) {
        // Basic implementation to remove HTML tags
        return html.replaceAll("<[^>]*>", "");
    }
}