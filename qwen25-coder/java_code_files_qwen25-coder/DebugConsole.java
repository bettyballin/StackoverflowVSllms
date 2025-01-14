import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DebugConsole extends JFrame {
    JTextArea inputArea;
    JTextArea outputArea;
    GroovyShell shell;

    public DebugConsole() {
        setTitle("Debug Console");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        inputArea = new JTextArea();
        JButton executeButton = new JButton("Execute");
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        // Setup layout
        setLayout(new BorderLayout());
        add(new JScrollPane(inputArea), BorderLayout.CENTER);
        add(executeButton, BorderLayout.SOUTH);
        add(new JScrollPane(outputArea), BorderLayout.EAST);

        // Groovy Shell setup
        Binding binding = new Binding();
        shell = new GroovyShell(binding);

        executeButton.addActionListener((ActionEvent e) -> {
            try {
                Object result = shell.evaluate(inputArea.getText());
                outputArea.append("Result: " + result + "\n");
            } catch (Exception ex) {
                outputArea.append("Error: " + ex.getMessage() + "\n");
            }
            inputArea.setText("");
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new DebugConsole().setVisible(true);
        });
    }
}