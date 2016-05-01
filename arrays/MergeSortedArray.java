package arrays;

/**
 * Created by VGN on 5/1/16.
 */
public class MergeSortedArray {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        assert (nums1.length >= m+n);
        if (n == 0)
            return ;
        //copy nums1 into auxillary array
        int[] aux = new int[m];
        for (int i =0; i< m; i++){
            aux[i] = nums1[i];
        }
        int i = 0;// pointer to aux
        int j =0;// pointer to nums2
        //compare aux with nums1
        for (int k=0; k< nums1.length; k++){
            if (i >= m){
                nums1[k] = nums2[j++];
            }
            else if (j >= n){
                nums1[k] = aux[i++];
            }
            else if (aux[i] > nums2[j]){
                nums1[k] = nums2[j++];
            }
            else{
                nums1[k] = aux[i++];
            }
        }

    }
}
