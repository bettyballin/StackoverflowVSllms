import java.lang.String;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CmdKeyLabel {
    FontIcon commandKeyIcon = (FontIcon) FontAwesomeIcon.FONT_ICON_COMMAND;
    JLabel cmdKeyLbl = new JLabel("", commandKeyIcon, SwingConstants.CENTER);
	public static void main(String[] args) {
	}
}

class FontIcon {
}

class FontAwesomeIcon {
    public static final FontIcon FONT_ICON_COMMAND = new FontIcon();
}