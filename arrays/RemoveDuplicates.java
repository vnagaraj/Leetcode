package arrays;

/**
 * Created by VGN on 5/1/16.
 */
public class RemoveDuplicates {
    /**
     Given a sorted array, remove the duplicates in place such that each element
     appear only once and return the new length.
     Do not allocate extra space for another array, you must do this in place with constant memory.
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <=1){
            return nums.length;
        }
        int i = 0;
        int j = 1;
        while ( j < nums.length){
            if (nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
            j++;
        }
        return i+1;

    }
}
