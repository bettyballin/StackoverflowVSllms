import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.ToHTMLContentHandler;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.xml.sax.SAXException;
import org.xml.sax.ContentHandler;

public class PDFtoHTML {
    public static void main(String[] args) throws IOException, SAXException, TikaException {
        String path = "path_to_your_file.pdf";
        InputStream is = new FileInputStream(new File(path));

        StringWriter writer = new StringWriter();
        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        TransformerHandler handler = factory.newTransformerHandler();
        handler.setResult(new StreamResult(writer));

        ContentHandler contentHandler = new ToHTMLContentHandler(handler);

        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();

        PDFParser parser = new PDFParser();

        try {
            parser.parse(is, contentHandler, metadata, parseContext);
            handler.endDocument(); // Convert the content and write it into StringWriter
            // Now, the HTML content is in 'writer'
            String htmlContent = writer.toString();
            // Do something with htmlContent
            System.out.println(htmlContent);
        } finally {
            is.close();
        }
    }
}