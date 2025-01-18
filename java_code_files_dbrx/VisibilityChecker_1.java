public class VisibilityChecker {
    public boolean isVisible(GameObject obj1, GameObject obj2) {
        if (Physics.Linecast(obj1.Position, obj2.Position)) return false; //object not visible
        return true; //otherwise - object is visible
    }
}

class GameObject {
    public Position Position;

    public GameObject(Position position) {
        this.Position = position;
    }
}

class Position {
    public double x, y, z;

    public Position(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Physics {
    public static boolean Linecast(Position pos1, Position pos2) {
        // Placeholder implementation
        // In a real scenario, this would check for obstructions between pos1 and pos2
        return false; // Assuming the line is clear
    }
}