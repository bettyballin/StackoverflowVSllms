import java.awt.*;
import javax.swing.*;

public class MazeRenderer_1_1 extends JPanel {
    private int[][] maze = {
        {0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0}
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 1) {
                    g.fillRect(j * 20, i * 20, 20, 20); // 20 is the width and height of each cell
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maze Renderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.add(new MazeRenderer_1());
        frame.setVisible(true);
    }
}