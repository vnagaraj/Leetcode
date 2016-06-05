package queues;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage {

    int size ;
    Queue<Integer> queue;
    private double total ;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new Queue<Integer>();
    }

    public double next(int val) {
        queue.enqueue(val);
        if (queue.getSize() > size){
            int value = queue.dequeue();
            total = total - value + val;
        } else {
            total += val;
        }
        return total / queue.getSize();
    }

    class Queue<Item>{

        Node first;
        Node last;
        private int size;

        private class Node {
            Item item;
            Node next;
            Node(Item item){
                this.item = item;
            }
        }

        public void enqueue(Item item){
            if (item == null){
                throw new RuntimeException("Cannot enqueue null item");
            }
            Node oldlast = last;
            last = new Node(item);
            if (oldlast != null) {
                oldlast.next = last;
            }
            if (first == null){
                first = last;
            }
            size +=1;
        }

        public Item dequeue(){
            if (size == 0){
                throw new RuntimeException("Cannot dequeue empty queue");
            }
            Item item = first.item;
            first = first.next;
            if (first == null){
                last = first;
            }
            size -= 1;
            return item;
        }

        public int getSize(){
            return size;
        }
    }
}
