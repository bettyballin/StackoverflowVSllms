import org.stringtemplate.v4.ST;

public class AlgorithmGenerator {
  public static String generateCSharpCode(int inputParameter1, int inputParameter2) {
    ST template = new ST("$if(inputParameter1 == 1)$ return \"one\" $elseif(inputParameter2 == 5)$ return \"five\" + inputParameter1 $else$ return \"not found\" $endif$");
    template.add("inputParameter1", inputParameter1);
    template.add("inputParameter2", inputParameter2);
    return template.render();
  }

  public static String generateJavaCode(int inputParameter1, int inputParameter2) {
    ST template = new ST("$if(inputParameter1 == 1)$ return \"one\"; $elseif(inputParameter2 == 5)$ return \"five\" + inputParameter1; $else$ return \"not found\"; $endif$");
    template.add("inputParameter1", inputParameter1);
    template.add("inputParameter2", inputParameter2);
    return template.render();
  }

  public static void main(String[] args) {
    System.out.println(generateCSharpCode(1, 0));
    System.out.println(generateCSharpCode(0, 5));
    System.out.println(generateCSharpCode(0, 0));
    System.out.println(generateJavaCode(1, 0));
    System.out.println(generateJavaCode(0, 5));
    System.out.println(generateJavaCode(0, 0));
  }
}