package arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by VGN on 4/21/16.
 */
public class MinRotatedSortedArrayTest {

    @Test
    public void test1(){
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        MinRotatedSortedArray m = new MinRotatedSortedArray();
        int result = m.findMin(nums);
        assertTrue(result == (0));
    }
}
