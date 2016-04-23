package unionfind;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

/**
 * Created by VGN on 12/6/15.
 * Test class for testing the unionfind
 */
public class NumberOfIslandsTest {

    @Test
    public void test1(){
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int islands = numberOfIslands.numIslands(grid);
        assertTrue(islands == (1));
    }

    @Test
    public void test2(){
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int islands = numberOfIslands.numIslands(grid);
        assertTrue(islands == (3));

    }

    @Test
    public void test3(){
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid = {{'1'}};
        int islands = numberOfIslands.numIslands(grid);
        assertTrue(islands == (1));

    }

}
