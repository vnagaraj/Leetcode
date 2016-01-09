package arrays;
import java.util.*;

/**
 * Created by VGN on 1/8/16.
 */
public class ThreeSum {

    /*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

            Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
            (-1, 0, 1)
            (-1, -1, 2)
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        //sort the array to do binary search
        Arrays.sort(nums);
        for (int i=0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int prevJ = -1;
            for (int j=i+1; j < nums.length; j++){
                if (prevJ != -1 && nums[j] == nums[prevJ]){
                    continue;
                }
                List<Integer> triplet = new ArrayList<Integer>();
                int target = nums[i] + nums[j];
                //do binary search on -target from j+1 index
                int index = binarySearch(nums, j+1, nums.length-1, -target);
                if (index != -1){
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[index]);
                    solution.add(triplet);
                }
                prevJ = j;
            }
        }
        return solution;
    }

    private int binarySearch(int[] nums, int low, int high, int value){
        if (low > high){
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (nums[middle] == value){
            return middle;
        }
        else if (nums[middle] < value){
            return binarySearch(nums, middle+1, high, value);
        }
        else {
            return binarySearch(nums,low, middle-1, value);
        }
    }

}
