package com.mycompany.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle2D;

import javax.swing.JPanel;

public class BarGraphPanel extends JPanel {

    private static final Color BACKGROUND = Color.WHITE;
    private static final Color FOREGROUND = Color.BLACK;

    private static final Color BORDER_COLOR = new Color(229, 172, 0);
    private static final Color BAR_GRAPH_COLOR = new Color(255, 255, 165);

    private int actual = 0;
    private int expected = 1;

    public BarGraphPanel() {
        super();
        setOpaque(true);
        setBackground(BACKGROUND);
        setPreferredSize(new Dimension(300, 30));
    }

    public void setActualAndExpected(int actual, int expected) {
        this.actual = actual;
        this.expected = expected;
        repaint(); // Request a repaint when the data changes
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call super to maintain default painting behavior

        double proportion = (expected == 0) ? 0 : ((double) actual) / expected;

        Graphics g2d = g.create();
        g2d.setColor(BAR_GRAPH_COLOR);
        g2d.fillRect(0, 0, (int) (getWidth() * proportion), getHeight());

        g2d.setColor(BORDER_COLOR);
        g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        FontMetrics metrics = g2d.getFontMetrics();
        String label = String.format("%s of %s (%.1f%%)", actual, expected, proportion * 100);
        Rectangle2D textBounds = metrics.getStringBounds(label, g2d);

        g2d.setColor(FOREGROUND);
        // Center the text vertically and offset horizontally
        g2d.drawString(label, (int) (getWidth() * proportion) + 5,
                (getHeight() - (int) textBounds.getHeight()) / 2 + metrics.getAscent());

        g2d.dispose();
    }

    public static void main(String[] args) {
        // Main method left empty as per original functionality
    }
}