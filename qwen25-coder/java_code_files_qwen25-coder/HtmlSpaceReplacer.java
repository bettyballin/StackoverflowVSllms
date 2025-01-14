import java.lang.String;
public class HtmlSpaceReplacer {
   String html = "<i>stack<span class=\"bold\">overflow</span></i>";
   {
       // Replace spaces with &nbsp;
       html = html.replace(" ", "&nbsp;");
   }

	public static void main(String[] args) {
	}
}