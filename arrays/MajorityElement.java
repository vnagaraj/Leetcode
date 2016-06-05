package arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

        public int majorityElement(int[] nums) {
            int[] aux = new int[nums.length];
            for (int i=0; i < aux.length; i++){
                aux[i] = nums[i];
            }
            return getMajorityElement(nums, 0, nums.length-1 , aux);
        }

        private static int merge(int[] a, int left, int right, int[] aux, int first, int second){
            int countfirstMajor = 0;
            int countsecondMajor = 0;
            int middle = (right - left)/2 + left;
            int i = left;
            int j = middle+1;
            for (int index=left; index <=right; index++){
                int value = -1;
                if (i > middle){
                    value = a[j++];
                }else if ( j> right){
                    value = a[i++];
                }else if (a[i] <= a[j]){
                    value = a[i++];
                } else{
                    value = a[j++];
                }
                if (value == first){
                    countfirstMajor += 1;
                }
                if (value == second){
                    countsecondMajor += 1;
                }
                aux[index] = value;

            }
            a = aux;
            int arrayLength = right - left +1;

            int countMajority = arrayLength/2 + 1;
            if (countfirstMajor >= countMajority) {
                return first;
            }
            return second;
        }

        private static int getMajorityElement(int[] a, int left, int right, int[] aux) {
            if (left >= right) {
                return a[left];
            }
            int middle = (right - left)/2 + left;
            int first = getMajorityElement(a, left, middle, aux);
            int second = getMajorityElement(a, middle+1, right, aux);
            return merge(a, left, right, aux, first, second);
        }

}
