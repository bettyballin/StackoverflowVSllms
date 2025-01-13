import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class BBCodeParserExample {
    public static void main(String[] args) throws Exception {
        // Create a lexer and parser
        CharStream input = CharStreams.fromString("[b]Hello World[/b]");
        BBCodeLexer lexer = new BBCodeLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BBCodeParser parser = new BBCodeParser(tokens);

        // Parse the input
        ParseTree tree = parser.start(); // This assumes 'start' is the entry point in your grammar

        // Print the parse tree
        System.out.println(tree.toStringTree(parser));
    }
}