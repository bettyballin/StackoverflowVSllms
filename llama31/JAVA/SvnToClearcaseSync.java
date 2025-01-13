import java.lang.String;
import org.clearsvn.ClearSVN;

public class SvnToClearcaseSync {
  public static void main(String[] args) {
    String svnUrl = "https://svn.example.com/repo";
    String ccVob = "my_vob";
    String ccView = "my_view";

    ClearSVN clearSVN = new ClearSVN();
    clearSVN.setSvnUrl(svnUrl);
    clearSVN.setCcVob(ccVob);
    clearSVN.setCcView(ccView);

    // Sync changes from SVN to Clearcase
    clearSVN.svnToClearcase();
  }
}