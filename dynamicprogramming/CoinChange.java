package dynamicprogramming;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] minimum = new int[amount+1];
        minimum[0] = 0;
        for (int i=1; i < amount +1; i++){
            float min = Float.MAX_VALUE;
            for (int j = 0; j < coins.length; j++){
                if (i >= coins[j]){
                    int value = minimum[i - coins[j]];
                    if (value == -1){
                        continue;
                    }
                    minimum[i] = 1 + value;
                    if (min > minimum[i]){
                        min = minimum[i];
                    }
                }
            }
            if (min == Float.MAX_VALUE){
                min = -1;
            }
            minimum[i] = (int) min;
        }
        return minimum[amount];
    }

    public static void main(String[] args){
        int[] coins = new int[] {1,2,5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }
}
