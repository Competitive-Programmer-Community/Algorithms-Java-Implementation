package Tree.BST;

import java.util.LinkedList;
import java.util.Queue;

// 增删查
public class BST implements IBST {
    private TreeNode root;

    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        root = add(root, val);
    }
    /**
     * 将val加入到以root为根的BST中
     * 通过递归实现插入
     * time: O(h)
     * space: O(h)
     * @param root
     * @param val
     * @return
     */
    private TreeNode add(TreeNode root, int val) {
        if (root == null) {
            size++;
            return new TreeNode(val);
        }

        if (root.val == val) {
            throw new IllegalArgumentException("节点已经存在");
        }

        if (root.val > val) {
            root.left = add(root.left, val);
        } else {
            root.right = add(root.right, val);
        }

        return root;
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }
    /**
     * 从以root为根的BST中删除val对应的节点
     * 通过递归实现删除
     * time: O(h)
     * space: O(h)
     * @param root
     * @param val
     * @return
     */
    private TreeNode remove(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val > val) {
            root.left = remove(root.left, val);
        } else if (root.val < val) {
            root.right = remove(root.right, val);
        } else {
            // 找到val对应的node，进行删除和替换操作
            size--;
            // 如果左子树为空，则将右子树提上去
            if (root.left == null) {
                return root.right;
                // 如果右子树为空，则将左子树提上去
            } else if (root.right == null) {
                return root.left;
            } else {
                // 如果左右子树均不为空，则从右子树中找到最小node，替换当前node；然后从右子树中删除最小node
                TreeNode minNode =  findMin(root.right);
                root.val = minNode.val;
                root.right = remove(root.right, minNode.val);
            }
        }

        return root;
    }
    /**
     * 找到以root为根的BST中的最小node
     * 通过递归实现查找
     * time: O(h)
     * space: O(h)
     * @param root
     * @return
     */
    private TreeNode findMin(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }
    /**
     * 在以root为根的BST中查找val对应的节点
     * 通过递归实现查找
     * time: O(h)
     * space: O(h)
     * @param root
     * @param val
     * @return
     */
    private boolean contains(TreeNode root, int val) {
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public void print() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()) {
            level++;
            System.out.print("第" + level + "层: ");
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(8);
        bst.add(5);
        bst.add(6);
        bst.add(3);
        bst.add(10);
        bst.add(9);
        bst.add(11);
        bst.remove(5);
        bst.print();
        System.out.println(bst.contains(11));
        System.out.println(bst.contains(12));

    }
}
