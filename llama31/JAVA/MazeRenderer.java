import java.lang.String;

public class MazeRenderer {
    public static void main(String[] args) {
        int[][] maze = {
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0}
        };

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 0) {
                    // Calculate the vacant space between pipes
                    int vacantSpace = 0;
                    for (int k = j; k < maze[i].length; k++) {
                        if (maze[i][k] == 1) {
                            break;
                        }
                        vacantSpace++;
                    }
                    // Use the vacantSpace variable to draw the dots
                    System.out.print(".".repeat(vacantSpace));
                    j += vacantSpace - 1;
                } else {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}