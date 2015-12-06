package linklist;
import java.util.PriorityQueue;

/**
 * Created by VGN on 12/5/15.
 */

/**
 * Definition for singly-linked list with a random pointer.
 */
 class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

/*
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

   /* Reverse a singly linked list.*/
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode forward = head; // pointer to forward list
        ListNode reverse = null; // pointer to reverse list
        while (forward != null){
            ListNode oldReverse = reverse;
            reverse = forward;
            forward = forward.next;
            reverse.next = oldReverse;
        }
        return reverse;

    }

    /*
    Remove all elements from a linked list of integers that have value val.

            Example
    Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
    Return: 1 --> 2 --> 3 --> 4 --> 5
    */
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = head;
        ListNode prev = null;
        while (start != null){
            if (start.val == val){
                if (head == start) {
                    //first node of list
                    head = start.next;
                    start = start.next;
                }
                else{
                    //regular case when node is middle of list
                    prev.next = start.next;
                    start = start.next;
                }
            }
            else{
                prev = start;
                start = start.next;
            }
        }
        return head;
    }

    /*Given a linked list, determine if it has a cycle in it. */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            slow = slow.next;
            if (slow == null)
                break;
            if (fast.next == null)
                break;
            fast = fast.next.next;
            if (fast == null)
                break;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /*
   Given link list, return the intersection node when cycle exists else return null
    */
    private ListNode getCycleNode(ListNode head){
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            slow = slow.next;
            if (slow == null)
                break;
            if (fast.next == null)
                break;
            fast = fast.next.next;
            if (fast == null)
                break;
            if (slow == fast)
                return slow;
        }
        return null;
    }

    /*
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    Note: Do not modify the linked list.
     */
    public ListNode detectCycle(ListNode head) {
        ListNode node = this.getCycleNode(head);
        if (node == null) {
            //no cycle exists
            return node;
        }
        //now move slow pointer to beginning of list and move slow and fast at same rate,
        //node at which the pointers intersect is starting point of cycle
        ListNode slow = head;
        ListNode fast = node;
        while (slow != fast){
            //break loop when two pointers intersect
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /*Sort a linked list using insertion sort.*/
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = null;
        while (head != null){
            if (sorted == null){
                // for first listnode
                sorted = head;
                head = head.next;
                sorted.next = null;
            }
            else if (head.val <= sorted.val){
                //easy case insert in front of list
                ListNode oldSorted = sorted;
                sorted = head;
                head = head.next;
                sorted.next = oldSorted;
            }
            else{
                //iterate through sorted list to find location to insert
                ListNode current = sorted;
                ListNode prev = null;
                while (current.val < head.val){
                    prev = current;
                    current = current.next;
                    if (current == null)
                        break;
                }
                ListNode copyhead = head.next;
                //insert node between prev and current
                ListNode oldcurrent = current;
                prev.next = head;
                head.next = current;
                head = copyhead;
            }

        }
        return sorted;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return head;
        }
        RandomListNode original = head;
        RandomListNode next = null;

        while (original != null){
            next = original.next;
            //insert new node in between each node in original list
            RandomListNode newNode = new RandomListNode(original.label);
            original.next = newNode;
            newNode.next = next;
            original = next;
        }

        original = head;
        RandomListNode copy = original.next;
        RandomListNode headcopy = copy;
        while (original != null) {
            //setting random pointers for copy list
            copy = original.next;
            RandomListNode oldCopyNext = copy.next;
            /*
            if (oldCopyNext != null)
                copy.next = oldCopyNext.next;
            else
                copy.next = null;
            */
            if (original.random != null)
                copy.random = original.random.next;
            else
                copy.random = null;
            //original.next = oldCopyNext;
            original = oldCopyNext;
        }
        original = head;
        while (original != null) {
            //restoring next pointers in original list and copy list
            copy = original.next;
            RandomListNode oldCopyNext = copy.next;
            original.next = oldCopyNext;
            if (oldCopyNext != null)
                copy.next = oldCopyNext.next;
            original = oldCopyNext;
        }
        return headcopy;
    }

    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
     the linked list should become 1 -> 2 -> 4 after calling your function.
     */
    public void deleteNode(ListNode node) {
        if (node.next == null){
            node = null;
        }
        int value = node.next.val;
        //edit the node value to have the next node's value
        node.val = value;
        //remove the next node
        node.next = node.next.next;
    }

    /*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.*/
    public ListNode mergeKLists(ListNode[] lists) {
        //complexity is k*n ( n is size of each list)
        //k*n log (n*k)
        if (lists.length == 0){
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        boolean isNull = false;
        //check for no null elements added to list
        while (!isNull){
            isNull = true;
            ListNode[] updatedLists = new ListNode[lists.length];
            for (int i=0; i < lists.length; i++){
                //insert the first item of each list into pq
                ListNode node = lists[i];
                if (node != null){
                    pq.add(node.val);
                    updatedLists[i] = node.next;
                    isNull = false;
                }
            }
            lists = updatedLists;
        }
        //store results from priority queue in sortedArray
        int[] sortedArray = new int[pq.size()];
        int counter = 0;
        //complexity is n*k log(n*k)
        while (!pq.isEmpty()){
           sortedArray[counter++] = pq.remove();
        }
        ListNode first = null;
        ListNode prevNode = null;
        //convert sorted array into list list
        //complexity is n
        for(int i= 0; i< sortedArray.length; i++){
            ListNode  node = new ListNode((sortedArray[i]));
            if (first == null){
                first = node;
            }
            if (prevNode != null){
                prevNode.next = node;
            }
            prevNode = node;
        }
        return first;
    }
}
