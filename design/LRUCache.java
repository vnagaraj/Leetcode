package design;

/**
 * Created by VGN on 12/3/15.
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * Implemented LRU using 2 data structures
 * 1) Linear Probing Hash Table to map the key to a queue node
 * 2) double link  list queue to keep track of least recently used node
 */
public class LRUCache<Key, Value> {
    private int capacity;
    private Node<Key, Value>[] nodes;
    private int size; // no of items currently in LRU cache
    // maintaining a queue with pointer to the first/last element of the list for LRU
    private Node first;  //node will be removed when cache reaches capacity since oldest
    private Node last;


    public LRUCache(int capacity) {
        nodes = (Node<Key, Value>[]) new Node[2 *capacity];
        // limit for LRUCache provided by client
        this.capacity = capacity;
    }

    /*
    Get the value (will always be positive) of the key if the key exists in the cache, otherwise return null.
     */
    public Value get(Key key){
        Node node = getNode(key);
        if (node != null){
            moveNodeToEndOfQueue(node);
            return (Value)node.val;
        }
        return null;
    }

    /*
    Helper method to move node to end of queue to indicate the node is most recently accessed
    Invoked by getter/setter methods
     */
    private void moveNodeToEndOfQueue(Node node){
        //since node is most recently accessed, move the node to end of queue
        if (last == null){
            last = node;
            first = last;
        }
        else {
            if (node == first){
                first = first.next;
            }
            //incase node is already last element in queue, no need to move node to back
            if (node != last) {
                //remove node from current position
                Node prev = node.prev;
                Node next = node.next;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null){
                    next.prev = prev;
                }
                Node oldlast = last;
                oldlast.next = node;
                node.prev = oldlast;
                node.next = null;
                last = node;
            }
            if (first == null) {
                //only 1 element
                first = last;
            }
        }
    }

    /*
    Return the node in array given the key
    Null if node not found in array
     */
    private Node getNode(Key key){
        int index = this.getIndexOfNode(key);
        if (index != -1){
            return this.nodes[index];
        }
        return null;
    }

    /*
    Return the index of the give node in array given the key,
    -1 if node not found in array
     */
    private int getIndexOfNode(Key key){
        int index = this.hash(key);
        while (nodes[index] != null ){
            if (nodes[index].key.equals(key)){
                return index;
            }
            index += 1;
            index = index % nodes.length;
        }
        return -1;
    }

    /*
     set(key, value) - Set or insert the value if the key is not already present.
     When the cache reached its capacity,it should invalidate the least recently used item before inserting a new item.
    */
    public void set(Key key, Value value) {
        //check if key exists
        Node node = this.getNode(key);
        if (node != null){
            //overwrite with new value
            node.val = value;
            //since node most recently accessed move to end of queue
            this.moveNodeToEndOfQueue(node);
            return;
        }
        if (size >= capacity){
            //invalidation of least recently used item step
            Key leastrecentKey = (Key) first.key;
            //reached capacity, remove node from front of queue
            first = first.next;
            int leastrecentIndex = this.getIndexOfNode(leastrecentKey);
            //derefrence node in array
            this.nodes[leastrecentIndex] = null;
        }
        else{
            size +=1;
        }
        int index = this.hash(key);
        while (nodes[index] != null) {
            index += 1;
            index = index % nodes.length;
        }
        node = new Node(key, value);
        nodes[index] = node ;
        this.moveNodeToEndOfQueue(node);
    }

    /*
    Return the index of the key based on the hash function
     */
    private int hash(Key key){
       return  (key.hashCode() & 0x7fffffff) % this.nodes.length;
    }

    /*
    Node class to keep track of Key,Value
     */
    private class Node<Key, Value> {
        Key key;
        Value val;
        Node prev;
        Node next;

        Node(Key key, Value value){
            this.key = key;
            this.val = value;
        }
    }
}