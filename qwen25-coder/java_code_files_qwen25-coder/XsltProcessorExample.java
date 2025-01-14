import java.io.File;

import net.sf.saxon.s9api.*;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class XsltProcessorExample {
    public static void main(String[] args) throws SaxonApiException {
        // Create a Processor instance
        Processor processor = new Processor(false);
        
        // Compile the XSLT stylesheet, loading it from a file
        XsltCompiler compiler = processor.newXsltCompiler();
        XsltExecutable executable = compiler.compile(new StreamSource(new File("example.xsl")));
        
        // Create a transformer for the compiled stylesheet
        Xslt30Transformer transformer = executable.load30();
        
        // Set the source document
        Source source = new StreamSource(new File("input.xml"));
        
        // Create a serializer for the output
        Serializer out = processor.newSerializer(System.out);
        
        // Perform the transformation
        transformer.applyTemplates(source, out);
    }
}