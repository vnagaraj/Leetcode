package arrays;

/**
 * Created by VGN on 4/27/16.
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        if (start > end){
            return -1;
        }
        int middle = start + (end - start)/2;
        if (nums[middle] == target){
            return middle;
        }
        else if (nums[start] <= nums[middle]){
            //part of increasing sequence
            if (target >= nums[start] && target <= nums[middle]){
                return binarySearch(nums, start, middle-1, target);
            }else{
                return binarySearch(nums, middle+1, end, target);
            }
        }
        else if (nums[middle] <= nums[end]){
            //part of increasing sequence
            if (target >= nums[middle] && target <= nums[end]){
                return binarySearch(nums, middle+1, end, target);
            }else{
                return binarySearch(nums, start, middle-1, target);
            }
        }
        else {
                int index = binarySearch(nums, start, middle-1, target) ;
                if (index == -1) {
                    return binarySearch(nums, middle + 1, end, target);
                }
                return index;
        }
    }
}
