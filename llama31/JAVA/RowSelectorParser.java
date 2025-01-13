import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class RowSelectorParserMain {
    public static void main(String[] args) {
        // Assuming you have a RowSelector.g4 grammar file and have run ANTLR to generate the parser and lexer
        String input = "your input string here";
        CharStream stream = CharStreams.fromString(input);
        RowSelectorLexer lexer = new RowSelectorLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RowSelectorParser parser = new RowSelectorParser(tokens);
        
        // Now you can use the parser to parse the input
        // For example:
        // parser.yourStartRule();
    }
}