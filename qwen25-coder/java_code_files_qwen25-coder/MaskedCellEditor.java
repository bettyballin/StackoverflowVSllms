import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class MaskedCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JFormattedTextField textField;
    private ErrorDialog errorDialog;

    public MaskedCellEditor() {
        textField = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        textField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                if (!((JFormattedTextField) input).isEditValid()) {
                    showError(input);
                    return false;
                }
                try {
                    new SimpleDateFormat("yyyy-MM-dd").parse(textField.getText());
                } catch (Exception e) {
                    showError(input);
                    return false;
                }
                hideError();
                return true;
            }

            private void showError(JComponent input) {
                if (errorDialog == null || !errorDialog.isVisible()) {
                    errorDialog = new ErrorDialog(SwingUtilities.getWindowAncestor(input), "Invalid date format");
                    errorDialog.setVisible(true);
                }
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                hideError();
            }
        });
    }

    private void hideError() {
        if (errorDialog != null && errorDialog.isVisible()) {
            errorDialog.dispose();
        }
    }

    // Cleanup method to be called when the table is destroyed
    public void cleanup() {
        if (errorDialog != null) {
            errorDialog.dispose();
        }
    }

    @Override
    public Object getCellEditorValue() {
        return textField.getValue();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        textField.setValue(value);
        return textField;
    }

    private class ErrorDialog extends JDialog {
        public ErrorDialog(Window parent, String message) {
            super(parent, Dialog.ModalityType.MODELESS); // Non-modal dialog
            setUndecorated(true);
            setLocationRelativeTo(textField); // Now 'textField' is accessible here
            add(new JLabel(message));
            pack();
            setVisible(true);

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    dispose();
                }
            });
        }
    }

    // Ensure to call cleanup when the table is no longer in use

    public static void main(String[] args) {
    }
}