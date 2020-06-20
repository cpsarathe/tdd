package csfundamental.dynprog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String[] ar) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        coinChange.coinChange(coins, amount);
    }
    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        Map<Integer,Integer> coinMap = new HashMap<>();
        int split = 0;
        int proxyAmount = amount;
        for(int x = coins.length - 1; x >=0 ; x--){
            if(coins[x] <= proxyAmount){
                split = proxyAmount / coins[x] ;
                if(split!=0) {
                    coinMap.put(coins[x],split);
                }
                proxyAmount = proxyAmount % coins[x];
            }
        }
        if(proxyAmount!=0){
            coinMap.clear();
        }
        System.out.println(coinMap);

        return 0;
    }

    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        Arrays.fill(amounts, amount + 1);
        amounts[0] = 0;
        for (int i = 1; i < amounts.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    //set the minimum number of coin needed for amount[i] , this uses backtracking via amounts[i-coin[j]]
                    amounts[i] = Math.min(amounts[i], 1 + amounts[i - coins[j]]);
                } else {
                    //when coins are bigger than amount value
                    break;
                }
            }
        }
        System.out.println(amounts[amount]);
        return amounts[amount] > amount ? -1 : amounts[amount];
    }
}
