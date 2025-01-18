import java.lang.String;
import java.lang.ArrayList;
import java.lang.List;
import java.awt.Rectangle;

public class QuadTreeNode_1 {
    public Rectangle bounds; // Rectangular region represented by this node
    private List<Rectangle> occupiedRegions = new ArrayList<>(); // Regions that are already occupying this area
    private QuadTreeNode_1[] children; // Child nodes dividing the space into smaller regions. Null if leaf node.

    public static void main(String[] args) {
    }
}