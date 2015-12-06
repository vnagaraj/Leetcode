package linklist;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

/**
 * Created by VGN on 12/6/15.
 * Test class for testing the mergeKsorted list method
 */
public class MergeKSortedListsTest {

    @Test
    public void test1(){
        ListNode node = new ListNode(1);
        ListNode[]  lists = new ListNode[]{node};
        assertTrue(new Solution().mergeKLists(lists).val == (1));
    }

    @Test
    public void test2(){
        ListNode node = new ListNode(1);
        ListNode[]  lists = new ListNode[]{null, node};
        assertTrue(new Solution().mergeKLists(lists).val == (1));
    }
}
