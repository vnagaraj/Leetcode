package arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class MinRotatedSortedArray {
    public int findMin(int[] nums) {
        int index = binarySearch(nums, 0, nums.length-1, -1);
        return nums[index];
    }

    private int binarySearch(int[] nums, int start, int end, int min){
        if (start > end){
            return min;
        }
        int middle = start + (end - start)/2;
        if (nums[middle] >= nums[start]){
            if (min == -1){
                min = start;
            }
            else if(nums[start] < nums[min]) {
                min = start;
            }
            return binarySearch(nums, middle+1, end, min);
        }
        else if (nums[middle] <= nums[end]){
            if (min == -1){
                min = middle;
            }
            else if(nums[middle] < nums[min]) {
                min = middle;
            }
            return binarySearch(nums, start, middle-1, min);
        }
        return min;
    }
}
