package heaps;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class FrequentItems {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        MaxPQ<Occurance> pq = new MaxPQ<Occurance>();
        for (int val: nums){
            if (map.containsKey(val)){
                map.put(val, map.get(val) + 1);
            } else{
                map.put(val, 1);
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Integer key = (Integer)pair.getKey();
            Integer value = (Integer) pair.getValue();
            pq.insert(new Occurance(key, value));
        }
        int counter = 0;
        while (counter++ < k){
            result.add(pq.delMax().key);
        }
        return result;

    }
}
class Occurance implements Comparable<Occurance> {
    int value;
    int key;
    Occurance(int key, int value){
        this.key = key;
        this.value = value;
    }
    @Override
    public int compareTo(Occurance o) {
        if (value < o.value){
            return -1;
        }
        if (value > o.value){
            return 1;
        }
        return 0;
    }
}
class MaxPQ<Key extends Comparable<Key>>{
    private int N; //size of priority queue;
    Key[] items;
    MaxPQ(){
        items = (Key[])new Comparable[2];
    }
    public Key getMax(){
        return items[1];
    }
    public Key delMax(){
        Key key = items[1];
        swap(1, N);
        items[N--] = null;
        sink(1);
        return key;
    }
    public int size(){
        return N;
    }
    public void insert(Key key){
        items[++N] = key;
        if (N+1 == items.length){
            resize(2 * items.length);
        }
        swim(N);
    }
    private void swim(int index){
        int parent = index/2;
        while (parent >= 1){
            if (less(parent, index)){
                swap(parent, index);
                index = parent;
                parent = index/2;
            }
            else{
                break;
            }
        }
    }
    private void sink(int index){
        int children = 2 * index;
        while (children <= N){
            if (children < N  && less(children, children+1)){
                children += 1;
            }
            if (!less(children, index)){
                swap(children, index);
            }
            index = children;
            children = 2 * index;
        }
    }
    private boolean less(int index1, int index2){
        if (items[index1].compareTo(items[index2]) <0){
            return true;
        }
        return false;
    }
    private void swap(int index1, int index2){
        Key tmp = items[index1];
        items[index1] = items[index2];
        items[index2] = tmp;
    }
    private void resize(int size){
        Key[] tmp = (Key[]) new Comparable[size];
        for (int i= 0; i < items.length; i++){
            tmp[i] = items[i];
        }
        items = tmp;
    }
}

