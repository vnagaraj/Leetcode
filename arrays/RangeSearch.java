package arrays;
/**
Given a sorted array of integers, find the starting and ending position of a given target value.

        Your algorithm's runtime complexity must be in the order of O(log n).

        If the target is not found in the array, return [-1, -1].

        For example,
        Given [5, 7, 7, 8, 8, 10] and target value 8,
        return [3, 4].
 */
public class RangeSearch {
    public int[] searchRange(int[] nums, int target) {
      return binarySearch(nums, 0, nums.length-1, target, new int[]{-1, -1});
    }

    int[] binarySearch(int[] nums, int start, int end, int target, int[] range){
        if (start > end){
            return range;
        }
        int middle = (end - start)/2 + start;
        if (nums[middle] == target){
            if (range[0] == -1 && range[1] == -1){
                int[] newRange = {middle, middle};
                int[] range1 = binarySearch(nums, start, middle-1, target, newRange);
                int[] range2 = binarySearch(nums, middle+1, end, target, newRange);
                return new int[]{range1[0], range2[1]};
            } else if (middle > range[0] && middle > range[1] ){
                int[] newRange = {range[0], middle};
                return binarySearch(nums, middle+1, end, target, newRange);
            } else if (middle < range[0] && middle < range[1] ){
                int[] newRange = {middle, range[1]};
                return binarySearch(nums, start, middle-1, target, newRange);
            }
        }
        if (nums[middle] > target){
            return binarySearch(nums, start, middle-1, target, range);
        }
        else if (nums[middle] < target){
           return  binarySearch(nums, middle+1, end, target, range);
        }
        return range;
    }
}
