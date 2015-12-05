package design;

/**
 * Created by VGN on 12/5/15.
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    MyStack<Integer> pushStack = new MyStack<Integer>();
    MyStack<Integer> minStack = new MyStack<Integer>();
    private int size ;

    public void push(int x) {
        pushStack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }
        else if (x <= minStack.peek()){
            minStack.push(x);
        }
        size += 1;
    }

    public void pop() {
        Integer val = pushStack.pop();
        if (val.equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return pushStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    class MyStack<Item> {

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

