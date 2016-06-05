package dynamicprogramming;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
       int m = word1.length();
       int n = word2.length();
       int penalty = 1;
       int[][] distance = new int[m+1][n+1];
       for (int i =0 ; i < m+1; i++){
           for (int j=0; j <n+1; j++){
               if (i == 0 ){
                   distance[i][j] = penalty * j;
                   continue;
               }
               if (j == 0){
                   distance[i][j] = penalty * i;
                   continue;
               }
               if (word1.charAt(i-1) == word2.charAt(j-1)){
                   distance[i][j] = Math.min(Math.min(distance[i-1][j-1], distance[i-1][j]+penalty),distance[i][j-1]+penalty);
               } else{
                   distance[i][j] = Math.min(Math.min(distance[i-1][j-1] +penalty, distance[i-1][j]+penalty),distance[i][j-1]+penalty);
               }
           }
       }
       return distance[m][n];
    }
}
