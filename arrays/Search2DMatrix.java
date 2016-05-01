package arrays;

/**
 * Created by VGN on 5/1/16.
 */
public class Search2DMatrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, 0, matrix.length * matrix[0].length-1,target);
    }

    private boolean binarySearch(int[][] matrix, int start, int end, int target){
        if (start > end){
            return false;
        }
        int colLength = matrix[0].length;
        int middle = start + (end-start)/2;
        int row =  middle/colLength;
        int col = middle%colLength;
        int middle_pos = matrix[row][col];
        if (target == middle_pos){
            return true;
        }
        if (target < middle_pos){
            return binarySearch(matrix, start, middle-1, target);
        }
        else{
            return binarySearch(matrix, middle+1, end, target);
        }
    }
}
