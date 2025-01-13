import java.lang.String;
// Use ANTLR's Java runtime to parse the input and generate HTML output
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class QuizGenerator {
    public static void main(String[] args) {
        // Create an instance of the parser
        QuizGrammarParser parser = new QuizGrammarParser(new CommonTokenStream(new QuizGrammarLexer(new ANTLRInputStream("What is your favorite color?\n* Blue\n* Green\n* Red"))));

        // Parse the input
        ParseTree tree = parser.quiz();

        // Generate HTML output
        StringBuilder html = new StringBuilder();
        html.append("<form action=\"\" method=\"post\">\n");
        html.append("  <ul>\n");

        for (QuestionContext question : tree.getQuestion()) {
            html.append("    <li>").append(question.getText()).append("</li>\n");

            for (AnswerContext answer : question.getAnswers()) {
                html.append("    <input type=\"radio\" name=\"q1\" answer=\"").append(answer.getText()).append("\" /> ").append(answer.getText()).append("<br />\n");
            }
        }

        html.append("  </ul>\n");
        html.append("</form>");

        System.out.println(html.toString());
    }
}