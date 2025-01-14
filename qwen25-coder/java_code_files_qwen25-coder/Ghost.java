public class Ghost {
    private int x;
    private int y;
    // Other attributes...

    public void moveTowardsPacman(PacMan pacMan) {
        int dx = pacMan.getX() - x;
        int dy = pacMan.getY() - y;

        if (dx != 0) { // Horizontal movement
            x += Math.signum(dx); // Move one pixel towards Pac-Man's X coordinate
        }

        if (dy != 0) { // Vertical movement
            y += Math.signum(dy); // Move one pixel towards Pac-Man's Y coordinate
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Methods to set x and y for testing purposes
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Main method to execute the code
    public static void main(String[] args) {
        // Create a PacMan object
        PacMan pacMan = new PacMan();
        pacMan.setX(5);
        pacMan.setY(5);

        // Create an array of Ghosts
        Ghost[] ghosts = new Ghost[3];
        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i] = new Ghost();
            ghosts[i].setX(0);
            ghosts[i].setY(0);
        }

        // In your game loop or update method:
        for (Ghost ghost : ghosts) {
            ghost.moveTowardsPacman(pacMan);
            System.out.println("Ghost position: (" + ghost.getX() + ", " + ghost.getY() + ")");
        }
    }
}

class PacMan {
    private int x;
    private int y;
    // Other attributes...

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Methods to set x and y
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}