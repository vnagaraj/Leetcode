package arrays;

/**
 * Created by VGN on 12/15/15.
 */
public class OrderStatistic {

    public int findKthLargest(int[] nums, int k) {
        int kstat = nums.length - 1 - (k - 1);
        return findKthStat(nums, 0, (nums).length - 1, kstat);
    }


    private int findKthStat(int[] nums, int startIndex, int endIndex, int kstat) {
        int index= partition(nums, startIndex, endIndex);
        if (index==kstat) {
            return nums[index];
        }
        if (index>kstat) {
            return findKthStat(nums, startIndex, index - 1, kstat);
        }
        else {
            return findKthStat(nums, index + 1, endIndex, kstat);
        }
    }


    private int  partition(int [] nums, int startIndex, int endIndex){
        int val = nums[startIndex];
        int i = startIndex + 1;
        int j = endIndex;
        while (startIndex < endIndex){
            while (val >= nums[i]) {
                i += 1;
                if(i >= endIndex){
                    break;
                }
            }
            while (val < nums[j]){
                j -=1;
                if (j <= startIndex){
                    break;
                }
            }
            if (i >= j ) {//pointers cross
                break;
            }
            //swap values at i and j pointer
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        //swap j with val
        nums[startIndex] = nums[j];
        nums[j] = val;
        return j;
    }

}
