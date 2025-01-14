import java.lang.String;
public class Quine {
   public static void main(String[] args) {
      char q = 34;
      String[] l = {
         "public class Quine {",
         "   public static void main(String[] args) {",
         "      char q = 34;",
         "      String[] l = {",
         "      };",
         "      for (String s : l) System.out.println(s);",
         "      for (String s : l) System.out.println(q + s + q + \",\");",
         "   }",
         "}"
      };
      for (String s : l) System.out.println(s);
      for (String s : l) System.out.println(q + s + q + ",");
   }
}