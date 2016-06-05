package sort;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by VGN on 5/2/16.
 */
public class InsertIntervalTest {

    @Test
    public void test1(){
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(6, 9);
        InsertInterval insertInterval = new InsertInterval();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        Interval newInterval = new Interval(2, 5);
        List<Interval> result = insertInterval.insert(intervals, newInterval);
        assertTrue(result.size() == 2);
        assertTrue(result.get(0).equals(new Interval(1,5)));
        assertTrue(result.get(1).equals(i2));

    }

    @Test
    public void test2(){
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(3, 5);
        Interval i3 = new Interval(6, 7);
        Interval i4 = new Interval(8, 10);
        Interval i5 = new Interval(12, 16);
        InsertInterval insertInterval = new InsertInterval();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
        Interval newInterval = new Interval(4, 9);
        List<Interval> result = insertInterval.insert(intervals, newInterval);
        assertTrue(result.size() == 3);
        assertTrue(result.get(0).equals(new Interval(1,2)));
        assertTrue(result.get(1).equals(new Interval(3,10)));
        assertTrue(result.get(2).equals(new Interval(12,16)));
    }

    @Test
    public void test3(){
        Interval i1 = new Interval(1, 5);
        InsertInterval insertInterval = new InsertInterval();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        Interval newInterval = new Interval(2, 3);
        List<Interval> result = insertInterval.insert(intervals, newInterval);
        assertTrue(result.size() == 1);
        assertTrue(result.get(0).equals(new Interval(1,5)));

    }
}
