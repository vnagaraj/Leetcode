package arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by VGN on 4/21/16.
 */
public class SearchRotatedSortedArrayTest {

    @Test
    public void test1(){
        int[] nums = {5, 1, 3};
        int target = 3;
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        int result = s.search(nums, target);
        assertTrue(result == (2));
    }

    @Test
    public void test2(){
        int[] nums = {3,4,5,6,1,2};
        int target = 2;
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        int result = s.search(nums, target);
        assertTrue(result == (5));
    }
}
