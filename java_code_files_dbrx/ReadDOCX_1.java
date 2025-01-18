import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import java.io.*;
public class ReadDOCX_1 {
    public static void main(String[] args) throws Docx4JException, FileNotFoundException {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File("input_path/file_name.docx"));
        System.out.println(wordMLPackage.getMainDocumentPart().getContent());
    }
}