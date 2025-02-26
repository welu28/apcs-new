package recursion;

public class CoinCombinations {
    public static int countWays(int amount, int[] coins, int index) {
        if (amount == 0) return 1;
        if (amount < 0 || index >= coins.length) return 0;
        
        return countWays(amount - coins[index], coins, index) + countWays(amount, coins, index + 1);
    }

    public static void main(String[] args) {
        int amount = 10;
        int[] coins = {1, 5, 10, 25};
        System.out.println("Total combinations: " + countWays(amount, coins, 0));
    }
}
