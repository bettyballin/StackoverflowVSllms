import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class QuadTreeNode {
    // Instance variables
    Rectangle bounds;
    QuadTreeNode[] children;
    List<Rectangle> occupiedAreas;
    int currentDepth;
    static final int MAX_DEPTH = 5; // Or another value

    public QuadTreeNode() {
        // Default constructor
        this(0, new Rectangle(0, 0, 100, 100)); // Default bounds
    }

    public QuadTreeNode(int depth, Rectangle bounds) {
        this.currentDepth = depth;
        this.bounds = bounds;
        children = null;
        occupiedAreas = new ArrayList<>();
    }

    public void addRectangle(Rectangle r) {
        if (!bounds.intersects(r)) return; // Rectangle doesn't intersect this node's bounds, do nothing
        if (children != null) { // If there are child nodes, try to insert the rectangle into them first
            for (QuadTreeNode child : children) child.addRectangle(r);
        } else { // Otherwise, store in occupiedAreas and split this node if necessary
            int intersectSize = 0; // Total area of rectangle that is covered by existing rectangles in occupiedAreas
            for (Rectangle n : occupiedAreas) intersectSize += getIntersectionArea(r, n);
            if ((1 - (double)intersectSize / (r.width * r.height) > 0.2 && currentDepth < MAX_DEPTH )) { // If less than 80% covered, split node into four child nodes and reassign occupiedAreas to them based on where they fit
               children = new QuadTreeNode[4];
               for (int i = 0; i < 4; i++) {
                   // Create child nodes with increased depth
                   children[i] = new QuadTreeNode(currentDepth + 1, calculateChildBounds(i));
               }
               for (Rectangle n : this.occupiedAreas) {
                   getChild(n).addRectangle(n);
               }
               // Also, add the current rectangle
               getChild(r).addRectangle(r);
               // Clear the occupiedAreas since they are now in children
               occupiedAreas.clear();
            } else { //If area is too small or mostly covered, add to occupiedAreas array at this node and quit insertion operation
                this.occupiedAreas.add(r);
            }
        }
    }

    public int getIntersectionArea(Rectangle r1, Rectangle r2) {
        Rectangle intersection = r1.intersection(r2);
        if (intersection.isEmpty()) {
            return 0;
        } else {
            return intersection.width * intersection.height;
        }
    }

    public QuadTreeNode getChild(Rectangle r) {
        for (QuadTreeNode child : children) {
            if (child.bounds.contains(r)) {
                return child;
            }
        }
        // If no child fully contains the rectangle, return the first child (arbitrary decision)
        return children[0];
    }

    public Rectangle calculateChildBounds(int index) {
        int halfWidth = bounds.width / 2;
        int halfHeight = bounds.height / 2;
        int x = bounds.x;
        int y = bounds.y;
        switch (index) {
            case 0: // Top-left
                return new Rectangle(x, y, halfWidth, halfHeight);
            case 1: // Top-right
                return new Rectangle(x + halfWidth, y, halfWidth, halfHeight);
            case 2: // Bottom-left
                return new Rectangle(x, y + halfHeight, halfWidth, halfHeight);
            case 3: // Bottom-right
                return new Rectangle(x + halfWidth, y + halfHeight, halfWidth, halfHeight);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        // Test code
        QuadTreeNode rootNode = new QuadTreeNode();
        Rectangle rect1 = new Rectangle(10, 10, 20, 20);
        Rectangle rect2 = new Rectangle(50, 50, 10, 10);
        rootNode.addRectangle(rect1);
        rootNode.addRectangle(rect2);
    }
}