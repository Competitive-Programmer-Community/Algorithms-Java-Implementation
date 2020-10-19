package Tree.BST;

public interface IBST {
    void add(int val);

    void remove(int val);

    boolean contains(int val);

    int size();

    boolean isEmpty();
}
