package Tree.RBT;

/**
 * 时间复杂度: O(logn)
 * 最大高度: O(log2n) -> 红黑交替
 * 对比AVL树: 增加/删除更优, 但查找AVL更好
 * 原因: 对于红黑树, 任何不平衡都会在三次旋转内解决
 * @param <Key>
 * @param <Value>
 */

public class RBT<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;
        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    public RBT() {}

    private boolean isRed(Node node) {
        if (root == null) {
            return false;
        }
        return node.color == RED;
    }
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key 为null");
        }
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        while(node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }

        return null;
    }

    private Node leftRotate(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        right.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;
        return right;
    }

    private Node rightRotate(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        left.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;
        return left;
    }

    private void flipColor(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("key 为null");
        }

        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        // 加入
        if (node == null) {
            return new Node(key, value, RED, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        // 翻转
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node);
        }

        node.size = node.left.size + node.right.size + 1;
        return node;
    }

    private void check() {
        if (!isBST()) System.out.println("不是BST");
        if (!isSize()) System.out.println("Size 不对");
        if (!is23()) System.out.println("不是2 - 3树");
        if (!isBalanced()) System.out.println("不是平衡树");
        System.out.println("是红黑树");

    }

    private boolean isBST() {
        return helper(root, null, null);
    }
    private boolean helper(Node node, Key min, Key max) {
        if (node == null) {
            return true;
        }
        if (max != null && node.key.compareTo(max) <= 0) {
            return false;
        }
        if (min != null && node.key.compareTo(min) <= 0) {
            return false;
        }

        return helper(node.left, min, node.key) && helper(node.right, node.key, max);
    }

    private boolean isSize() {
        return isSize(root);
    }

    private boolean isSize(Node node) {
        if (node == null) {
            return true;
        }

        if (node.size != size(node.left) + size(node.right) + 1) {
            return false;
        }
        return isSize(node.left) && isSize(node.right);
    }

    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node node) {
        if (node == null) {
            return true;
        }

        if (isRed(node.right)) {
            return false;
        }

        if (node != root && isRed(node) && isRed(node.left)) {
            return false;
        }

        return is23(node.left) && is23(node.right);
    }

    // 黑平衡 -> 从root出发到每个叶子节点经历的黑色节点个数相同
    private boolean isBalanced() {
        int black = 0;
        Node node = root;
        while(node != null) {
            if (!isRed(node)) {
                black++;
            }

            node = node.left;
        }

        return isBalanced(root, black);
    }

    private boolean isBalanced(Node node, int black) {
        if (node == null) {
            return black == 0;
        }
        if (!isRed(node)) {
            black--;
        }
        return isBalanced(node.left, black) && isBalanced(node.right, black);
    }

    public static void main(String[] args) {

    }
}

