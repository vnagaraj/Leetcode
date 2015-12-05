package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * Definition for an interval.
 **/
 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class MergeInterval{
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <=1){
            return intervals;
        }
        Interval[] intervalsArray = new Interval[intervals.size()];
        intervalsArray = intervals.toArray(intervalsArray);
        Arrays.sort(intervalsArray, new IntervalComparator());
        ArrayList<Interval> mergedList = new ArrayList<Interval>();
        int index = 0;
        Interval interval = intervalsArray[index++];
        Interval interval1 = null;
        boolean overlapped = false;
        while (index < intervalsArray.length){
            interval1 = intervalsArray[index];
            if (isOverlapInterval(interval, interval1)){
                int max = -1;
                if (interval.end < interval1.end )
                    max = interval1.end;
                else
                    max = interval.end;
                interval = new Interval(interval.start, max);
                overlapped = true;
            }
            else{
                if (overlapped)
                    overlapped = false;
                mergedList.add(interval);
                interval = interval1;
            }
            index ++;

        }
        mergedList.add(interval);
        return mergedList;
    }

    private boolean isOverlapInterval(Interval i1, Interval i2){
        if ((i1.end >= i2.start) || (i1.start == i2.start && i1.end < i2.end)){
            return true;
        }
        return false;
    }
}

class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval i1, Interval i2) {
        if (i1.start > i2.start)
            return 1;
        if (i1.start == i2.start && i1.end > i2.end){
            return 1;
        }
        if (i1.start == i2.start && i1.end == i2.end){
            return 0;
        }
        return -1;
    }
}