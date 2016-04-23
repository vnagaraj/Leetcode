package unionfind;

import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands2 {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        WeightedUnionFind uf = new WeightedUnionFind(m * n);
        int[][] grid = new int[m][n];
        List<Integer> result = new ArrayList<Integer>();
        int cc = 0;
        for (int i = 0; i < positions.length; i++){
            cc +=1;
            int[] op = positions[i];
            int row = op[0];
            int col = op[1];
            grid[row][col] = 1;
            int gridPos = (row * n ) + col;
            int[] neighbors = getNeighbors(row, col, grid);
            boolean connection = false;
            for (int neighbor : neighbors){
                if (neighbor == -1){
                    continue;
                }
                int neRow = neighbor/n;
                int neCol = neighbor%n;
                if (grid[neRow][neCol] != 0){
                    if (!uf.connected(gridPos, neighbor)){
                      uf.union(gridPos, neighbor);
                      cc -=1;
                    }
                }
            }
            result.add(cc);
        }
        return result;

    }

    public int[] getNeighbors(int i, int j, int[][] grid){
        int length = grid.length;
        int width = grid[0].length;
        int pos = (i * width ) + j;
        int up ,down ,left, right = 1;
        if (i == 0){
            up = -1;
        }
        else{
            up = pos - width;
        }
        if (i == length -1){
            down = -1;
        }
        else{
            down = pos + width;
        }
        if (j == 0){
            left = -1;

        }
        else{
            left = pos -1;
        }
        if (j == width -1){
            right = -1;
        }
        else{
            right = pos +1;
        }
        return new int[]{up, down, left, right};
    }

    class WeightedUnionFind{
        private int[] id;
        private int[] size; //size to do the weighted computation

        WeightedUnionFind(int N){
            id = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++){
                id[i] = i;
                size[i] = 1;
            }
        }

        int findRoot(int i){
            while (id[i] != i){
                i = id[i];
            }
            return i;
        }

        boolean connected(int p, int q){
            int i = findRoot(p);
            int j = findRoot(q);
            if (i == j){
                return true;
            }
            return false;
        }

        void union(int p, int q){
            int i = findRoot(p);
            int j = findRoot(q);
            if (i == j){
                return ;
            }
            if (size[i] < size[j]){
                id[i] = j;
                size[j] += size[i];
            }
            else {
                id[j] = i;
                size[i] += size[j];
            }
        }

    }

}
