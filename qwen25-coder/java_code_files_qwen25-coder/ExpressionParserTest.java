import java.lang.String;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ExpressionParserTest {
    public static void main(String[] args) throws Exception {
        String expression = "1 + (2 * 3)";
        CharStream charStream = CharStreams.fromString(expression);
        SimpleGrammarLexer lexer = new SimpleGrammarLexer(charStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);

        SimpleGrammarParser parser = new SimpleGrammarParser(tokenStream);
        ParseTree tree = parser.parse();

        System.out.println("Parse Tree:\n" + tree.toStringTree(parser));
    }
}