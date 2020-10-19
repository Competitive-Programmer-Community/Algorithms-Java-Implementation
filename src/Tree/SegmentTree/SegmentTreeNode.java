package Tree.SegmentTree;

public class SegmentTreeNode {
    int start;
    int end;
    SegmentTreeNode left;
    SegmentTreeNode right;
    int sum;

    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }

    public int mid() {
        return start + (end - start) / 2;
    }
}

