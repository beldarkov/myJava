public class Tree<V extends Comparable<V>> {
    private Node root;

    class Node {
        private V value;
        private Color color;
        private Node leftChild;
        private Node rightChild;
    }

    private boolean addNode(Node node, V value) {
        if (node.value.compareTo(value) == 0) {
            return false;
        } else {
            if (node.value.compareTo(value) > 0) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = reBalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = reBalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = node.leftChild;

        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = node.rightChild;

        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node reBalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED && result.leftChild.leftChild != null &&
                    result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED && result.rightChild != null &&
                    result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    private Node leftRotate(Node node) {
        Node newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;
        newRoot.color = node.color;
        node.color = Color.RED;
        return newRoot;
    }

    private Node insert(Node node, V value) {
        if (node == null) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.color = Color.RED;
            return newNode;
        }

        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.leftChild = insert(node.leftChild, value);
        } else if (cmp > 0) {
            node.rightChild = insert(node.rightChild, value);
        } else {
            return node;
        }

        if (isRed(node.rightChild) && !isRed(node.leftChild)) {
            node = leftRotate(node);
        }
        if (isRed(node.leftChild) && isRed(node.leftChild.leftChild)) {
            node = rightSwap(node);
        }
        if (isRed(node.leftChild) && isRed(node.rightChild)) {
            colorSwap(node);
        }
        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    public boolean add(V value) {
        root = insert(root, value);
        if (root != null) {
            root.color = Color.BLACK;
            return true;
        } else {
            return false;
        }
    }

    public enum Color {
        RED, BLACK
    }
}
