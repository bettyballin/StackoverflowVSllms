import com.podfabrica.wordml.to.pdf.Converter;

public class ConvertWordToPdf {
    public static void main(String[] args) throws Exception {
        Converter converter = new Converter();
        converter.convert("input.xml", "output.pdf");
    }
}