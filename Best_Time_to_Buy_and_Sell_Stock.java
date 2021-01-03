class Solution {
    public int maxProfit(int[] prices) {
        int priceMin = Integer.MAX_VALUE;
        int answerMax = 0;
        for(int item : prices){
            priceMin = Math.min(priceMin,item);
            answerMax = Math.max(answerMax,item-priceMin);
        }
        return answerMax;
    }
}
