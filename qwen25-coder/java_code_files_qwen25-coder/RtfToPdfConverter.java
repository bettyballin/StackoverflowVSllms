import java.lang.String;
import com.itextpdf.html2pdf.HtmlConverter;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import java.io.*;

public class RtfToPdfConverter {

    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException {
        File inputRTF = new File("input.rtf");
        File outputPDF = new File("output.pdf");

        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        .newDocument());

        HWPFDocument document = new HWPFDocument(new FileInputStream(inputRTF));
        wordToHtmlConverter.processDocument(document);
        Document htmlDocument = wordToHtmlConverter.getDocument();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer serializer = factory.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.MEDIA_TYPE, "text/html");

        serializer.transform(domSource, streamResult);

        byte[] buffer = out.toByteArray();
        String content = new String(buffer);
        HtmlConverter.convertToPdf(content, new FileOutputStream(outputPDF));
    }
}