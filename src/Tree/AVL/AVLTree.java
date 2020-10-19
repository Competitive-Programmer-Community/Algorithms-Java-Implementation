package Tree.AVL;

public class AVLTree implements IAVLTree {
    AVLNode root;

    int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        root = add(root, val);
    }

    private AVLNode add(AVLNode root, int val) {
        if (root == null) {
            size++;
            return new AVLNode(val);
        }

        if (root.val == val) {
            throw new IllegalArgumentException("节点已经存在");
        }

        if (root.val > val) {
            root.left = add(root.left, val);
        } else {
            root.right = add(root.right, val);
        }

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balanceFactor = getBalanceFactor(root);
        // 从当前root开始向上不平衡，且root和root.left均须满足左高右低
        if (balanceFactor > 1 && getBalanceFactor(root.left) >= 0) {
            return rightRotate(root);
        }
        // 从当前root开始向上不平衡，且root和root.right均须满足左低右高
        if (balanceFactor < -1 && getBalanceFactor(root.right) <= 0) {
            return leftRotate(root);
        }
        if (balanceFactor > 1 && getBalanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balanceFactor < -1 && getBalanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    // LL -> 左不平右旋转
    private AVLNode rightRotate(AVLNode root) {
        AVLNode left = root.left;
        AVLNode right = left.right;
        left.right = root;
        root.left = right;
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        left.height = 1 + Math.max(getHeight(left.left), getHeight(left.right));
        return left;
    }
    // RR -> 右不平左旋转
    private AVLNode leftRotate(AVLNode root) {
        AVLNode right = root.right;
        AVLNode left = right.left;
        right.left = root;
        root.right = left;
        // 先更新下面的root, 然后更新left/right
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        right.height = 1 + Math.max(getHeight(right.left), getHeight(right.right));
        return right;
    }
    // LR(以root为中心左高右低, 以root.left为中心左低右高) : 以root.left为中心进行右旋变成LL, 然后以root.left为中心进行左旋放在右子树上
    // RL(以root为中心左低右高, 以root.right为中心左高右低) : 以root.right为中心进行左旋变成RR, 然后以root.right为中心进行右旋放在左子树上



    private int getHeight(AVLNode root) {
        return root == null ? 0: root.height;
    }
    private int getBalanceFactor(AVLNode root) {
        return root == null ? 0 : getHeight(root.left) - getHeight(root.right);
    }


    private boolean isBST(AVLNode root) {
        return helper(root, null, null);
    }
    private boolean helper(AVLNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (max != null && root.val <= max) {
            return false;
        }
        if (min != null && root.val >= min) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }


    private boolean isBalanced(AVLNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }
    // 返回以root为根的tree的高度
    private int helper(AVLNode root) {
        if (root == null) {
            return 0;
        }

        int l = helper(root.left);
        int r = helper(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }

        return 1 + Math.max(l, r);
    }

    private boolean isBalanced2(AVLNode root) {
        if (root == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor == -1) {
            return false;
        }

        return isBalanced2(root.left) && isBalanced(root.right);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }
    private AVLNode remove(AVLNode root, int val) {
        if (root == null) {
            return null;
        }

        AVLNode changeNode;

        if (root.val > val) {
            root.left = remove(root.left, val);
            changeNode = root;
        } else if (root.val < val) {
            root.right = remove(root.right, val);
            changeNode = root;
        } else {
            // 找到val对应的node，进行删除和替换操作
            size--;
            if (root.left == null) {
                changeNode = root.right;
            } else if (root.right == null) {
                changeNode = root.left;
            } else {
                AVLNode minNode =  findMin(root.right);
                root.val = minNode.val;
                root.right = remove(root.right, minNode.val);
                changeNode = root;
            }
        }

        if (changeNode == null) {
            return null;
        }

        changeNode.height = 1 + Math.max(getHeight(changeNode.left), getHeight(changeNode.right));
        int balanceFactor = getBalanceFactor(changeNode);
        // 从当前root开始向上不平衡，且root和root.left均须满足左高右低
        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) >= 0) {
            return rightRotate(changeNode);
        }
        // 从当前root开始向上不平衡，且root和root.right均须满足左低右高
        if (balanceFactor < -1 && getBalanceFactor(changeNode.right) <= 0) {
            return leftRotate(changeNode);
        }
        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) < 0) {
            changeNode.left = leftRotate(changeNode.left);
            return rightRotate(changeNode);
        }
        if (balanceFactor < -1 && getBalanceFactor(changeNode.right) > 0) {
            changeNode.right = rightRotate(changeNode.right);
            return leftRotate(changeNode);
        }

        return changeNode;
    }

    private AVLNode findMin(AVLNode root) {
        while(root.left != null) {
            root = root.left;
        }

        return root;
    }


    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(AVLNode root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        }

        if (root.val < val) {
            return contains(root.right, val);
        } else {
            return contains(root.left, val);
        }
    }
}

