package UnionFind;

public class UnionFind {
    int[] father;

    public UnionFind(int count) {
        father = new int[count];
        for (int i = 0; i < count; i++) {
            father[i] = i;
        }
    }

    /**
     * time average:  建立O(n)，查询O(1)
     * space: O(n)
     * union by weight: 将元素较少的集合union到元素较多的集合，进行union操作的元素个数少 int[] size, 比较size[i]
     * union by rank: 将高度较小的集合union到高度较大的集合，保证树的深度不变化，查找次数少 int[] rank, 比较rank[i]
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        if (root_x != root_y) {
            father[root_y] = root_x;
        }
    }

    /**
     * time average: O(1)
     * find parent and path compression
     * @param x
     * @return
     */
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }

        return father[x] = find(father[x]);
    }

    /**
     * time: O(1)
     * @param x
     * @param y
     * @return
     */
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

