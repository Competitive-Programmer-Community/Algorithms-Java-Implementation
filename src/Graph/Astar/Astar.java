package Graph.Astar;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给定一个grid的width和height，start，end以及blocks
 * 找出grid上面从start到end的最短路径和其min cost（默认为四个方向的移动，每一步cost为1）
 * grid上面的point三种状态：
 * 1 closedCells：已经访问过
 * 2 openCells：将要访问并已放入pq
 * 3 未被访问且没有放入pq
 */

public class Astar {

    // v or h move cost
    public static final int V_H_COST = 1;

    private Cell[][] grid;

    private Cell start;

    private Cell end;

    private Set<String> closedCells; // "x,y"

    private PriorityQueue<Cell> openCells; // sort all the cells by their final cost

    public Astar(int width, int height, int startX, int startY, int endX, int endY, int[][] blocks) {
        grid = new Cell[width][height];
        start = new Cell(startX, startY);
        end = new Cell(endX, endY);
        closedCells = new HashSet<>();
        openCells = new PriorityQueue<Cell>((Cell a, Cell b) -> {
            return a.finalCost - b.finalCost;
        });
        
        // init heuristic cost for every cell using mahatan distance
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Cell(i, j);
                grid[i][j].heuristicCost = Math.abs(i - endX) + Math.abs(j - endY);
            }
        }
        
        // init the start cell
        grid[startX][startY].finalCost = 1;
        closedCells.add(startX + "," + startY);

        // add block cells into grid
        for (int i = 0; i < blocks.length; i++) {
            grid[blocks[i][0]][blocks[i][1]] = null;
        }
    }

    // update the final cost of next cell, may add into pq
    public void updateCostIfNeeded(Cell current, Cell next, int cost) {
        // if next is block
        if (next == null) {
            return;
        }
        // if next has been visited
        if (closedCells.contains(next.x + "," + next.y)) {
            return;
        }

        // if next has not been visited
        int nextFinalCost = next.heuristicCost + cost;
        boolean isOpen = openCells.contains(next);

        // 1 if next has not been added into pq, update cost and add it into pq
        // 2 if next has been added into pq, but the cost should be updated -> update cost
        if (!isOpen || nextFinalCost < next.finalCost) {
            next.finalCost = nextFinalCost;
            next.parent = current;

            if (!isOpen) {
                openCells.add(next);
            }
        }
    }

    public void process() {
        openCells.add(start);
        int[] dX = {1, -1, 0, 0};
        int[] dY = {0, 0, 1, -1};

        while(!openCells.isEmpty()) {
            Cell current = openCells.poll();
            closedCells.add(current.x + "," + current.y);
            if (current.equals(end)) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dX[i];
                int ny = current.y + dY[i];
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                    continue;
                }
                if (grid[nx][ny] == null) {
                    continue;
                }
                if (closedCells.contains(nx + "," + ny)) {
                    continue;
                }

                Cell next = grid[nx][ny];
                updateCostIfNeeded(current, next, current.finalCost + V_H_COST);
            }

        }
    }

    public void display() {
        System.out.println("Grid: ");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == start.x && j == start.y) {
                    System.out.print("S   ");
                } else if (i == end.x && j == end.y) {
                    System.out.print("D   ");
                } else if (grid[i][j] == null){
                    System.out.print("*   ");
                } else {
                    System.out.print("0   ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showScores() {
        System.out.println("\nScores for cells: ");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    System.out.print("*  ");
                } else {
                    System.out.printf("%-3d", grid[i][j].finalCost);
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    public void showPath() {
        if (closedCells.contains(end.x + "," + end.y)) {
            System.out.println("Path: ");
            String path = "";
            Cell current = grid[end.x][end.y];
            path += current.toString();
            while(current != null) {
                current = current.parent;
                if (current != null) {
                    path = current.toString() + " -> " + path;
                }
            }
            System.out.println(path);

        } else {
            System.out.println("There are no paths between " + start.toString() + " and " + end.toString());
        }
    }


    public static void main(String[] args) {
        Astar astar = new Astar(5, 5, 0, 0, 3, 2, new int[][] {
                {0, 4}, {2, 2}, {3, 1}, {3, 3}, {2, 1}, {2, 3}
        });

        astar.display();
        astar.process();
        astar.showScores();
        astar.showPath();
    }
}
