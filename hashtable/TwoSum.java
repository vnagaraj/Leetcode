package hashtable;

import java.util.HashMap;

/**
 * Created by VGN on 1/8/16.
 */
public class TwoSum {

    /*
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target,
    where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
     */
    public int[] twoSum(int[] nums, int target) {
        //store in hash table with key = number and value =occurances of number
        //store in hash table with key = number and value = int[] indixes of the number in nums array
        HashMap<Integer, Integer> numberCount = new HashMap<Integer, Integer>();
        HashMap<Integer, int[]> numberIndices = new HashMap<Integer, int[]>();
        for (int i=0; i < nums.length; i++){
            if (!numberCount.containsKey(nums[i])){
                numberCount.put(nums[i], 1);
                numberIndices.put(nums[i], new int[]{i+1});
            }
            else{
                numberCount.put(nums[i], numberCount.get(nums[i])+1);
                int[] res = numberIndices.get(nums[i]);
                numberIndices.put(nums[i], new int[]{res[0], i+1});
            }
        }
        //iterate through nums array  to find target using hash table
        for (int val: nums){
            if (target - val == val && numberCount.get(val) == 1){
                continue;
            }
            if (target - val == val && numberCount.get(val) != 1){
                return numberIndices.get(val);
            }
            if (numberIndices.containsKey(target - val)){
                return new int[]{numberIndices.get(val)[0], numberIndices.get(target-val)[0]};
            }
        }
        return null;
    }

}
