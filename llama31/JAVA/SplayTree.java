// Splay Tree
class SplayTree {
    private Node root;

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return splay(node, key);
    }

    private Node splay(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            if (node.left != null && key < node.left.key) {
                node.left.left = splay(node.left.left, key);
                node = rotateRight(node);
            } else if (node.left != null) {
                node.left = splay(node.left, key);
            }

            return node.left == null ? node : rotateRight(node);
        } else if (key > node.key) {
            if (node.right != null && key > node.right.key) {
                node.right.right = splay(node.right.right, key);
                node = rotateLeft(node);
            } else if (node.right != null) {
                node.right = splay(node.right, key);
            }

            return node.right == null ? node : rotateLeft(node);
        }

        return node;
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }
}

// Red-Black Tree
class RedBlackTree {
    private Node root;

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key, Node.RED);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return balance(node);
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        } else if (isRed(node.right) && isRed(node.right.right)) {
            node = rotateLeft(node);
        } else if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == Node.RED;
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = Node.RED;
        return temp;
    }

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = Node.RED;
        return temp;
    }

    private void flipColors(Node node) {
        node.color = Node.RED;
        node.left.color = Node.BLACK;
        node.right.color = Node.BLACK;
    }

    private class Node {
        static final boolean RED = true;
        static final boolean BLACK = false;

        int key;
        Node left;
        Node right;
        boolean color;

        Node(int key, boolean color) {
            this.key = key;
            this.color = color;
        }
    }
}

// AVL Tree
class AVLTree {
    private Node root;

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return balance(node);
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    private int getBalanceFactor(Node node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node) {
        return node == null ? 0 : 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }
}

// B-Tree
class BTree {
    private Node root;
    private int degree;

    public BTree(int degree) {
        this.degree = degree;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(degree);
            root.keys[0] = key;
            root.numKeys++;
        } else {
            if (root.numKeys == (2 * degree) - 1) {
                Node temp = new Node(degree);
                temp.children[0] = root;
                splitChild(temp, 0);
                insertNonFull(temp, key);
                root = temp;
            } else {
                insertNonFull(root, key);
            }
        }
    }

    private void insertNonFull(Node node, int key) {
        if (node.leaf) {
            int i = node.numKeys - 1;
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.numKeys++;
        } else {
            int i = node.numKeys - 1;
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }

            if (node.children[i + 1].numKeys == (2 * degree) - 1) {
                splitChild(node, i + 1);
                if (key > node.keys[i + 1]) {
                    i++;
                }
            }
            insertNonFull(node.children[i + 1], key);
        }
    }

    private void splitChild(Node parent, int index) {
        Node child = parent.children[index];
        Node temp = new Node(degree);
        parent.children[index + 1] = temp;

        parent.keys[index] = child.keys[degree - 1];
        temp.leaf = child.leaf;

        System.arraycopy(child.keys, degree, temp.keys, 0, degree - 1);
        System.arraycopy(child.children, degree, temp.children, 0, degree);

        child.numKeys = degree - 1;
        temp.numKeys = degree - 1;
    }

    private class Node {
        int degree;
        int numKeys;
        int[] keys;
        Node[] children;
        boolean leaf;

        Node(int degree) {
            this.degree = degree;
            numKeys = 0;
            keys = new int[(2 * degree) - 1];
            children = new Node[2 * degree];
            leaf = true;
        }
    }
}

// T-Tree
class TTree {
    private Node root;

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return balance(node);
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    private int getBalanceFactor(Node node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node) {
        return node == null ? 0 : 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        SplayTree splayTree = new SplayTree();
        RedBlackTree redBlackTree = new RedBlackTree();
        AVLTree avlTree = new AVLTree();
        BTree bTree = new BTree(3);
        TTree tTree = new TTree();

        splayTree.insert(10);
        splayTree.insert(20);
        splayTree.insert(30);

        redBlackTree.insert(10);
        redBlackTree.insert(20);
        redBlackTree.insert(30);

        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);

        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(30);

        tTree.insert(10);
        tTree.insert(20);
        tTree.insert(30);
    }
}