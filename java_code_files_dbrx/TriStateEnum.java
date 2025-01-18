import java.lang.String;
public class TriStateEnum {
    enum TriState {
      YES() { @Override public boolean isYes() { return true; } },
      NO() {}, /* could override with false if you want */
      GREEN() {}; // or perhaps treat this as a "special" case in your code where needed.

      public boolean isYes() {
          return false;
      }
    }
	public static void main(String[] args) {
	}
}