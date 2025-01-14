import javax.swing.*;
import javax.validation.constraints.NotBlank;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Set;

public class FormValidatorExample {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormValidatorExample::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Form Validation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 10));
        JTextField nameField = new JTextField();
        JButton submitButton = new JButton("Submit");

        MyBean myBean = new MyBean();

        nameField.setText(myBean.getName());

        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        submitButton.addActionListener((ActionEvent e) -> {
            myBean.setName(nameField.getText());
            Set<ConstraintViolation<MyBean>> violations = validator.validate(myBean);
            if (violations.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Form is valid!");
            } else {
                StringBuilder sb = new StringBuilder();
                for (ConstraintViolation<MyBean> violation : violations) {
                    sb.append(violation.getMessage()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, sb.toString(), "Validation Errors", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(submitButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class MyBean {
        @NotBlank(message = "Name cannot be blank")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}