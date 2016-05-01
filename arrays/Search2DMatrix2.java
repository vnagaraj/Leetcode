package arrays;

/**
 * Created by VGN on 5/1/16.
 */
public class Search2DMatrix2 {

    /**
     Searches for a value in an m x n matrix. This matrix has the following properties:
     Integers in each row are sorted in ascending from left to right.
     Integers in each column are sorted in ascending from top to bottom.
     * @param matrix
     * @param target
     * @return true if found , false otherwise
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; //row count
        int n = matrix[0].length; //col count
        int i = 0; //row pointer starting from 1st row
        int j = n -1; //col pointer starting from 1st col
        while (i < m && j >= 0){
            int value = matrix[i][j];
            if (target == value){
                return true; //found target
            }
            else if (target > value){
                i += 1; //increment row pointer
            } else{
                j -= 1; //decrement col pointer
            }
        }
        return false; //target not found
    }
}
