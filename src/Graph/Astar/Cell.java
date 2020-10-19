package Graph.Astar;

public class Cell {
    // cell coordinates
    public int x, y;

    // the last cell on the path
    public Cell parent;

    // the heuristic cost from the cell to the end
    public int heuristicCost;

    // the final cost from the start to the cell
    public int finalCost;

    // whether the given cell is on the path
    boolean onPath;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[ " + this.x + "," + this.y + " ]";
    }
}
