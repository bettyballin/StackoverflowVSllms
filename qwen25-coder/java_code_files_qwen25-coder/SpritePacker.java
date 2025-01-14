import java.util.List;
import java.awt.Image;

class Rectangle {
    int x, y, width, height;

    Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}

class Node {
    Node leftChild, rightChild;
    Rectangle rect;

    Node(Rectangle rect) {
        this.rect = rect;
    }

    boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
}

public class SpritePacker {
    public String packImages(List<Image> images) {
        // Initial rectangle to hold everything
        int width = 0, height = 0;
        Node root = new Node(new Rectangle(0, 0, width, height));

        for (Image image : images) {
            int imageWidth = image.getWidth(null);
            int imageHeight = image.getHeight(null);

            Node node = findNode(root, imageWidth, imageHeight);
            if (node == null) {
                root = growNode(root, imageWidth, imageHeight);
                node = findNode(root, imageWidth, imageHeight);
                if (node == null) {
                    // Couldn't fit image
                    continue;
                }
            }

            node.leftChild = new Node(new Rectangle(node.rect.x, node.rect.y, imageWidth, imageHeight));
            node.rightChild = splitNode(node, imageWidth, imageHeight);

            // Update sprite dimensions
            width = Math.max(width, node.rect.x + imageWidth);
            height = Math.max(height, node.rect.y + imageHeight);
        }

        return generateSpriteCSS(root, width, height);
    }

    private Node findNode(Node root, int width, int height) {
        if (!root.isLeaf()) {
            Node node = findNode(root.leftChild, width, height);
            if (node != null) {
                return node;
            }
            return findNode(root.rightChild, width, height);
        } else {
            if (width <= root.rect.width && height <= root.rect.height) {
                return root;
            } else {
                return null;
            }
        }
    }

    private Node growNode(Node root, int width, int height) {
        boolean canGrowDown = (width <= root.rect.width);
        boolean canGrowRight = (height <= root.rect.height);

        boolean shouldGrowRight = canGrowRight && (root.rect.height >= (root.rect.width + width));
        boolean shouldGrowDown = canGrowDown && (root.rect.width >= (root.rect.height + height));

        if (shouldGrowRight) {
            return growRight(root, width, height);
        } else if (shouldGrowDown) {
            return growDown(root, width, height);
        } else if (canGrowRight) {
            return growRight(root, width, height);
        } else if (canGrowDown) {
            return growDown(root, width, height);
        } else {
            return null; // Can't grow
        }
    }

    private Node growRight(Node root, int width, int height) {
        Node newRoot = new Node(new Rectangle(0, 0, root.rect.width + width, root.rect.height));
        newRoot.leftChild = root;
        newRoot.rightChild = new Node(new Rectangle(root.rect.width, 0, width, root.rect.height));
        return newRoot;
    }

    private Node growDown(Node root, int width, int height) {
        Node newRoot = new Node(new Rectangle(0, 0, root.rect.width, root.rect.height + height));
        newRoot.leftChild = root;
        newRoot.rightChild = new Node(new Rectangle(0, root.rect.height, root.rect.width, height));
        return newRoot;
    }

    private Node splitNode(Node node, int width, int height) {
        node.leftChild = new Node(new Rectangle(node.rect.x, node.rect.y + height, width, node.rect.height - height));
        node.rightChild = new Node(new Rectangle(node.rect.x + width, node.rect.y, node.rect.width - width, node.rect.height));
        return node.leftChild;
    }

    private String generateSpriteCSS(Node root, int width, int height) {
        // Generate CSS based on the final layout
        // Example: .image1 { background-position: x y; }
        return "";
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}