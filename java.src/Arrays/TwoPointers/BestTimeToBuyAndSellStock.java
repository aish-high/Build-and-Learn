package Arrays.TwoPointers;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        //Two pointers
        int l=0, r=1, profit, maxProfit = 0;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                profit = prices[r]-prices[l];
                maxProfit = Math.max(profit,maxProfit);
            } else
                l=r;
            r++;
        }
        System.out.println("Max profit: "+maxProfit);
        //DP
        int i=0, buy=prices[0];
        maxProfit = 0;
        while(i<prices.length){
            buy = Math.min(prices[i],buy);
            profit = prices[i] - buy;
            maxProfit = Math.max(profit,maxProfit);
            i++;
        }
        System.out.println("Max profit: "+maxProfit);
    }
}
