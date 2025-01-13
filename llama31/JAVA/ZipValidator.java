import java.lang.String;
public class ZipValidator {
  public static boolean isValidZip(String zip) {
    String regex = "^\\d{5}(-\\d{4})?$";
    return zip.matches(regex);
  }

	public static void main(String[] args) {
	}
}