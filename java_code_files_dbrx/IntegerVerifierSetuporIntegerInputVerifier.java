import javax.swing.JTextField;

public class IntegerVerifierSetuporIntegerInputVerifier {
    JTextField myField = new JTextField();

    {
        myField.setInputVerifier(new MyIntegerVerifier());
    }

    public static void main(String[] args) {
    }
}