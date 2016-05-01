package arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

/**
 * Created by VGN on 4/21/16.
 * Unit test for testing sorted row/col functionality
 */
public class Search2DMatrix2Test {

    @Test
    public void test1(){
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
                };
        Search2DMatrix2 m = new Search2DMatrix2();
        assertTrue(m.searchMatrix(matrix, 5));
        assertFalse(m.searchMatrix(matrix, 20));
    }
}
