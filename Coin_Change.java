class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        int total=0;

        if(amount==0)
            return 0;

        for(int i=0; i<=amount; i++) {
            for(int money : coins) {
                if(money <= i){
                    dp[i]=Math.min(dp[i],dp[i-money]+1);
                }
            }
        }
        if(dp[amount]==amount+1){
            return -1;
        }
        return dp[amount];
    }
}
