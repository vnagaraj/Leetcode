package unionfind;

/**
 * Created by VGN on 4/21/16.
 */
public class WeightedUnionFind{
    private int[] id;
    private int[] size; //size to do the weighted computation
    private int count; // no of connected components

    WeightedUnionFind(int N, int cc){
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            size[i] = 1;
        }
        count = cc;
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
        count --;
    }

    int getCC(){
        return count;
    }


}

