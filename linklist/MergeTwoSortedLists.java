package linklist;

/**
 * Created by VGN on 4/25/16.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = null; // pointer to first element in merged list
        ListNode last = null; // pointer to last element in merged list
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            } else if (l1 == null || l2 == null) {
                ListNode l = null;
                if (l1 == null) {
                    l = l2;
                } else if (l2 == null) {
                    l = l1;
                }
                if (first == null) {
                    first = l;
                    last = first;
                } else {
                    ListNode oldlast = last;
                    last = l;
                    oldlast.next = last;
                }
                break;
            } else {
                ListNode l = null;
                if (l1.val <= l2.val) {
                    l = l1;
                    l1 = l1.next;
                } else {
                    l = l2;
                    l2 = l2.next;
                }
                if (first == null) {
                    first = l;
                    l = l.next;
                    last = first;
                } else {
                    ListNode oldlast = last;
                    last = l;
                    oldlast.next = last;
                }
            }
        }
        return first;

    }
}