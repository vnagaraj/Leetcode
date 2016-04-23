package unionfind;

/**
 * Created by VGN on 4/21/16.
 */
public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        WeightedUnionFind unionFind = new WeightedUnionFind(n, n);
        for (int i =0; i < edges.length; i++){
            int[] edge = edges[i];
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.getCC();
    }
}
