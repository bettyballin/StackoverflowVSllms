import com.sun.codemodel.*;
import java.io.*;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class JaxbExample {
  public static void main(String[] args) throws Exception {
    JAXBContext jc = JAXBContext.newInstance("hello"); // package name where generated classes will reside
    Unmarshaller u = jc.createUnmarshaller();
    Object o = u.unmarshal(new StreamSource((InputStream)null)); // Input XML content. Can be File, InputStream etc.
  }
}