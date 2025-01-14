import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFTextReplacer extends PDFStreamEngine {
    private String searchString;
    private String replacementString;

    public PDFTextReplacer(String searchString, String replacementString) {
        this.searchString = searchString;
        this.replacementString = replacementString;
    }

    @Override
    protected void processOperator(Operator operator, List<COSBase> operands)
            throws IOException {
        super.processOperator(operator, operands);
        if (operator.getName().equals("Tj")) {
            COSBase base0 = operands.get(0);
            if (base0 instanceof COSString) {
                String string = ((COSString) base0).getString();
                if (string.contains(searchString)) {
                    String newString = string.replace(searchString, replacementString);
                    operands.set(0, new COSString(newString));
                }
            }
        } else if ("'".equals(operator.getName())) { // case of operator TJ
            for (int i = 0; i < operands.size(); i++) {
                COSBase obj = operands.get(i);
                if (obj instanceof COSString) {
                    String string = ((COSString) obj).getString();
                    if (string.contains(searchString)) {
                        String newString = string.replace(searchString, replacementString);
                        operands.set(i, new COSString(newString));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("input.pdf");
        try (PDDocument document = PDDocument.load(file)) {
            PDFTextReplacer pdfTextReplacer = new PDFTextReplacer(
                    "http://old-url.com", // text to find
                    ""); // text to replace with

            for (int i = 0; i < document.getNumberOfPages(); i++) {
                pdfTextReplacer.processPage(document.getPage(i));
            }

            document.save("output.pdf");
        }
    }
}