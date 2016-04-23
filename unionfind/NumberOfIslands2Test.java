package unionfind;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by VGN on 12/6/15.
 * Test class for testing the unionfind
 */
public class NumberOfIslands2Test {

    @Test
    public void test1(){
        NumberOfIslands2 numberOfIslands = new NumberOfIslands2();
        int[][] pos = {{0,0},{0,1},{1,2},{2,1}};
        List<Integer> islands = numberOfIslands.numIslands2(3, 3, pos);
        assertTrue(islands.size() == (4));
        assertTrue(islands.get(0) == 1);
        assertTrue(islands.get(1) == 1);
        assertTrue(islands.get(2) == 2);
        assertTrue(islands.get(3) == 3);
    }
}
