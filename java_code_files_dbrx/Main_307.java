import com.orctom.osxkeychain.OsxKeychain;
import com.orctom.osxkeychain.enums.SEC_ITEM_CLASS;
import com.orctom.osxkeychain.model.SecOsxUserAccount;

public class Main_307 {
  public static void main(String[] args) throws Exception {
    OsxKeychain keychain = OsxKeychain.INSTANCE;

    String account = "youraccount";
    String password = "yourpassword";
    // store item
    boolean success = keychain.add(
        "",
        new SecOsxUserAccount(account).getBytes(),
        "secGenericPasswordItem".getBytes(),
        SEC_ITEM_CLASS.KEY,
        0
    );

    // try to retrieve item
    if (success) {
      byte[] passwordData = keychain.findByService("secGenericPasswordItem".getBytes()).get(0).getKey();
      // decoding bytes back into a string
      String decodedPassword = new String(passwordData, "UTF-8");
      System.out.println("Retrieved: " + decodedPassword);
    }
  }
}