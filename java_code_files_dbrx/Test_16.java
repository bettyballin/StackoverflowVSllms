import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Test_16 {
  public static List<String> permute(String a) {
      // base case
      if (a == null || a.length() < 2){
          ArrayList<String> al = new ArrayList<>();
          al.add(a);
          return al;
      }

      List<String> permutations = new LinkedList<>();
      int n = a.length();
      char initial = a.charAt(0); // first character
      String rem = a.substring(1); // cut off the rest of the string after the first character

      for (String s : permute(rem)) {
          System.out.println("s: " + s);
           for (int i=0; i < n; ++i) {
               permutations.add(charInsert(s, initial, i));
           }
       }
      return permutations;
  }

  public static String charInsert(String str, char c, int j){
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
   }

   public static void main(String[] args) {
      System.out.println("permute of 'abc' is " + permute("abc"));
  }
}