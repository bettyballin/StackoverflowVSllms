/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class DateVerifier
extends InputVerifier {
    private final DateFormat dateFormat;

    public DateVerifier(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean verify(JComponent jComponent) {
        if (jComponent instanceof JTextComponent) {
            JTextComponent jTextComponent = (JTextComponent)jComponent;
            String string = jTextComponent.getText();
            try {
                this.dateFormat.parse(string);
                return true;
            }
            catch (ParseException parseException) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] stringArray) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateVerifier dateVerifier = new DateVerifier(simpleDateFormat);
        DateVerifier dateVerifier2 = new DateVerifier(simpleDateFormat2);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setInputVerifier(dateVerifier);
        JTextArea jTextArea2 = new JTextArea();
        jTextArea2.setInputVerifier(dateVerifier2);
        JFrame jFrame = new JFrame("Date Verifier");
        jFrame.add(jTextArea);
        jFrame.add(jTextArea2);
        jFrame.setDefaultCloseOperation(2);
        jFrame.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        jFrame.setSize(400, 300);
        jFrame.setVisible(true);
    }
}
