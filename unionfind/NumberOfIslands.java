package unionfind;

/**
 * Created by VGN on 4/21/16.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        if (length == 0 || width == 0){
            return 0;
        }
        int connectedCom = 0;
        for (int row = 0; row < length; row ++){
            for (int col=0; col < width; col++){
                if (grid[row][col] == '1'){
                    connectedCom ++;
                }
            }
        }
        WeightedUnionFind uf = new WeightedUnionFind(length * width , connectedCom);
        int pos = 0;
        for (int row = 0; row < length; row ++){
            for (int col = 0; col < width; col++){
               if (grid[row][col] != '1') {
                   pos +=1;
                   continue;
               }


               int[] neighbors = getNeighbors(row, col, grid);
               for (int neigbhor : neighbors){
                   if (neigbhor != -1){

                       int val = grid[row][col];
                       int neRow = neigbhor/width;
                       int neCol = neigbhor% width;
                       int neVal = grid[neRow][neCol];
                       if (neVal == '1') {
                           uf.union(pos, neigbhor);
                       }
                   }
               }
               pos +=1;
            }

        }
        return uf.getCC();
    }

    public int[] getNeighbors(int i, int j, char[][] grid){
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
}

