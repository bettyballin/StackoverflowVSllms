import java.lang.String;
// Example of SHA-256 hash calculation
     import java.security.MessageDigest;
     public class HashExample_1 {
         public static void main(String[] args) throws Exception {
             MessageDigest md = MessageDigest.getInstance("SHA-256");
             byte[] hash = md.digest("Your data here".getBytes());

             StringBuilder sb = new StringBuilder();
             for (byte b : hash) {
                 sb.append(String.format("%02x", b));
             }
             System.out.println(sb.toString());
         }
     }
