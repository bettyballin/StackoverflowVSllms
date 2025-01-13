/*
 * Decompiled with CFR 0.152.
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.rtf.RTFEditorKit;

public class RTF2JPG
extends JPanel {
    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("RTF2JPG");
        jFrame.setDefaultCloseOperation(3);
        jFrame.getContentPane().add(new RTF2JPG());
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public RTF2JPG() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 300));
        JTextComponent jTextComponent = this.makeTextComponent();
        this.add((Component)new JScrollPane(jTextComponent), "Center");
    }

    private JTextComponent makeTextComponent() {
        JTextPane jTextPane = new JTextPane();
        jTextPane.setEditorKit(new RTFEditorKit());
        jTextPane.setText("Some RTF text");
        return jTextPane;
    }

    public void convertRtfToJpg(String string) {
        try {
            JEditorPane jEditorPane = new JEditorPane();
            RTFEditorKit rTFEditorKit = new RTFEditorKit();
            jEditorPane.setEditorKit(rTFEditorKit);
            rTFEditorKit.read(new FileInputStream(string), jEditorPane.getDocument(), 0);
            Document document = jEditorPane.getDocument();
            int n = document.getLength();
            String string2 = document.getText(0, n);
            File file = new File(string + ".pdf");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
