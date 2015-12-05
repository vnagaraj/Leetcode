package design;

/**
 * Created by VGN on 12/5/15.
 * Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 */
public class StackUsingQueues {
    ArrayQueue<Integer> queue1 = new ArrayQueue<Integer>();
    ArrayQueue<Integer> queue2 = new ArrayQueue<Integer>();
    int size;

    // Push element x onto stack.
    public void push(int x) {
        if (queue2.isEmpty()){
            queue1.enqueue(x);
        }
        else{
            queue2.enqueue(x);
        }
        size += 1;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (size ==0){
            throw new RuntimeException("Cannot remove from empty stack");
        }
        size -=1;
        while (!queue1.isEmpty()){
            Integer val = queue1.dequeue();
            if (queue1.size != 0) {
                queue2.enqueue(val);
            }
            else{
                return;
            }
        }

        while (!queue2.isEmpty()){
            Integer val = queue2.dequeue();
            if (queue2.size != 0) {
                queue1.enqueue(val);
            }
            else {
                return;
            }
        }
    }

    // Get the top element.
    public int top() {
        int val = -1;
        if (size ==0){
            throw new RuntimeException("Cannot get top from empty stack");
        }
        while (!queue1.isEmpty()){
            val = queue1.dequeue();
            queue2.enqueue(val);
        }
        while (!queue2.isEmpty()){
            val = queue2.dequeue();
            queue1.enqueue(val);
        }
        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return size ==0;
    }

    class ArrayQueue<Item> {

        private Item[] array;
        int size;
        int start_index; // to keep track for dequeue
        int end_endex; // to keep track for enqueue

        ArrayQueue(){
            array = (Item[])new Object[1];
        }

        public void enqueue(Item item){
            if (end_endex == array.length){
                resize(end_endex*2);
            }
            array[end_endex] = item;
            size ++;
            end_endex++;
        }

        private void resize(int length){
            Item[] temp =  (Item[])new Object[length];
            int index = 0;
            int counter = 0;
            for (int i=0; i< array.length ; i++){
                if( array[i] != null) {
                    temp[counter++] = array[i];
                }
            }
            start_index =0;
            end_endex = counter;
            array = temp;
        }

        public Item dequeue(){
            //remove item from front of list
            if (size == 0){
                throw new RuntimeException("Cannot dequeue from empty queue");
            }
            Item item = array[start_index];
            array[start_index] = null; // to avoid loitering
            start_index+=1;
            size --;
            return item;
        }

        public Item peek(){
            if (size == 0){
                throw new RuntimeException("Cannot dequeue from empty queue");
            }
            return array[start_index];
        }

        public boolean isEmpty(){
            return size ==0;
        }

        public int size(){
            return size;
        }
    }}
