package graph;


import org.testng.annotations.Test;

/**
 * Created by VGN on 12/10/15.
 */
public class CourseScheduleTest {
    @Test
    public void test1(){
        int[][] preq = {
            {1,0}
        };
        CourseSchedule courseSchedule = new CourseSchedule();
        int [] order = courseSchedule.findOrder(2, preq);
    }
}
