package design;

/**
 * Created by VGN on 12/5/15.
 * Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 */
public class QueueUsingStacks {
    // Push element x to the back of queue.
    LinkedListStack<Integer> stack1 = new LinkedListStack<Integer>();
    LinkedListStack<Integer> stack2 = new LinkedListStack<Integer>();
    private int size ;

    public void push(int x) {
        stack1.push(x);
        size += 1;
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (size == 0){
            throw new RuntimeException("Cannot pop from empty queue");
        }
        if (!stack2.isEmpty()){
            stack2.pop();
        }
        else{
            while (!stack1.isEmpty()){
                Integer val = stack1.pop();
                stack2.push(val);
            }
            stack2.pop();
        }
        size -= 1;

    }

    // Get the front element.
    public int peek() {
        if (!stack2.isEmpty()){
            return stack2.peek();
        }
        else{
            while (!stack1.isEmpty()){
                Integer val = stack1.pop();
                stack2.push(val);
            }
            return stack2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return size == 0;
    }

    class LinkedListStack<Item> {

        Node first;
        int size;


        private class Node{
            Item item;
            Node next;

            Node(Item item){
                this.item = item;
            }
        }

        void push(Item item){
            Node oldfirst = first;
            first = new Node(item);
            first.next = oldfirst;
            size += 1;
        }

        Item pop(){
            if (size == 0){
                throw new RuntimeException("Cannot pop from empty stack");
            }
            Item item = first.item;
            first = first.next;
            size -= 1;
            return item;
        }

        Item peek(){
            if (size == 0){
                throw new RuntimeException("Cannot peek from empty stack");
            }
            return first.item;
        }

        boolean isEmpty(){
            return size ==0;
        }



    }
}




