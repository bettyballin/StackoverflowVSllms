public class QuadTreeNode {

    // Instance variables
    Rectangle bounds;
    QuadTreeNode[] children;

    public boolean isFreeSpace(Rectangle r, QuadTreeNode node) {
        // Check if given rectangle can fit into any subspace (leafnode) under a specified root.
        if (!bounds.overlaps(r)) return false; // No overlap with region at this depth
        if (children != null && isFreeSpaceRecursive(r, children)) {
            // If there are child nodes and we found free space in one of them - then free space exists as well for parent
            return false; // Quit checking after finding a suitable subspace.
        } else {
           // If no free spaces were found after searching all possible leaf nodes - area is not free overall.
            return true;
        }
    }

    public boolean isFreeSpaceRecursive(Rectangle r, QuadTreeNode[] nodes) {
        // Placeholder implementation
        for (QuadTreeNode child : nodes) {
            if (child.isFreeSpace(r, child)) {
                return true;
            }
        }
        return false;
    }
}

class Rectangle {
    public int x, y, width, height;

    public boolean overlaps(Rectangle other) {
        return !(other.x >= x + width || 
                 other.x + other.width <= x || 
                 other.y >= y + height ||
                 other.y + other.height <= y);
    }
}