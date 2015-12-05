package sort;

/**
 * Created by VGN on 12/5/15.
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color
 * are adjacent, with the colors in the order red, white and blue.
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColor {
    public void sortColors(int[] nums) {
        for (int i=0; i < nums.length; i++){
            for (int j=i; j > 0; j--){
                if (nums[j] < nums[j-1]){
                    //swap entries
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                else
                    break;
            }
        }

    }
}
