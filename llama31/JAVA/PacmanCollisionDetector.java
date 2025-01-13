public class PacmanCollisionDetector {
    public static void main(String[] args) {
        int[][] maze = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {1, 1, 1, 0}};
        int pacmanX = 40;
        int pacmanY = 20;

        if (maze[pacmanX / 20][pacmanY / 20] == 1) {
            System.out.println("Pacman has collided with a wall");
        }
    }
}