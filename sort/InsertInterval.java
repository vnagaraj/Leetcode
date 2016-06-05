package sort;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null){
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        int i  =0; //pointer to intervals
        while ( i < intervals.size()){
            Interval interval = intervals.get(i);
            if (newInterval == null){
                result.add(interval);
            }
            else if (!isOverlap(interval, newInterval)){
                //check for smaller interval
                if (newInterval.start <= interval.start){
                    result.add(newInterval);
                    newInterval = null;
                }
                result.add(interval);

            } else {
                //update new interval
                newInterval = mergeIntervals(interval, newInterval);
            }
            i ++;
        }
        if (newInterval != null){
            result.add(newInterval);//incase merging last interval
        }
        return result;
    }

    private boolean isOverlap(Interval i1, Interval i2){
        if (i1.start < i2.start){
            if (i2.start <= i1.end){
                return true;
            }
            return false;
        }
        else if (i2.start < i1.start){
            if (i1.start <= i2.end){
                return true;
            }
            return false;
        }
        return true;
    }

    private Interval mergeIntervals(Interval i1, Interval i2){
        Interval mergedInterval = new Interval();
        if (i1.start < i2.start){
            mergedInterval.start = i1.start;
        } else{
            mergedInterval.start = i2.start;
        }
        if (i1.end < i2.end){
            mergedInterval.end = i2.end;
        } else{
            mergedInterval.end = i1.end;
        }
        return mergedInterval;
    }
}
