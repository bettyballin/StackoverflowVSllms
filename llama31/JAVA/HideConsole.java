import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseEvent;

public class HideConsole {
    public static void main(String[] args) {
        SystemTray.getSystemTray().add(new HideConsoleTrayIcon());
    }
}

class HideConsoleTrayIcon extends java.awt.TrayIcon {
    public HideConsoleTrayIcon() {
        super(null, "Hide Console");
        setPopupMenu(null);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.exit(0);
    }
}