import javax.swing.*;

public class MyIntegerVerifier extends InputVerifier {
    @Override
    public boolean verify(JComponent comp) {
        JTextField tf = (JTextField) comp; // make sure this component is a TextField type beforehand!
        try {
            Integer.parseInt(tf.getText());
            return true; // it's an integer, valid input
        } catch (Exception e) {
            return false; // not valid, throw error or warning message to user
        }
    }

    public static void main(String[] args) {
    }
}