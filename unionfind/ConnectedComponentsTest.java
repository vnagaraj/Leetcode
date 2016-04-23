package unionfind;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by VGN on 4/21/16.
 */
public class ConnectedComponentsTest {

    @Test
    public void test1(){
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        ConnectedComponents cc = new ConnectedComponents();
        int count = cc.countComponents(5, edges);
        assertTrue(count == (2));
    }

    @Test
    public void test2(){
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        ConnectedComponents cc = new ConnectedComponents();
        int count = cc.countComponents(5, edges);
        assertTrue(count == (1));
    }
}
