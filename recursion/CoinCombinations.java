package recursion;

public class CoinCombinations {
    public static int countWays(int amount, int[] coins, int index) {
        if (amount == 0) return 1;
        if (amount < 0 || index >= coins.length) return 0;
        
        return countWays(amount - coins[index], coins, index) + countWays(amount, coins, index + 1);
    }

    public static void main(String[] args) {
        int amount = 100;
        int[] coins = {25, 10, 5, 1};
        System.out.println("total combinations: " + countWays(amount, coins, 0));
    }
}
