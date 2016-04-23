package arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by VGN on 4/21/16.
 */
public class RangeSearchTest {

    @Test
    public void test1(){
        int[] nums = {5, 7, 7, 8, 8, 10};
        RangeSearch rs = new RangeSearch();
        int[] result = rs.searchRange(nums, 8);
        assertTrue(result[0] == (3));
        assertTrue(result[1] == (4));
    }
}
