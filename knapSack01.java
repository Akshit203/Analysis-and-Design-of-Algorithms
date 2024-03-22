public class knapSack01 {
    
    public static int knap_sack(int[] weights, int[] values, int capacity) {

        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= capacity; w++) {

                if (weights[i - 1] <= w) {

                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } 
                else {
                    dp[i][w] = dp[i - 1][w];
                }

            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        int[] weights = {2, 3, 4, 5};

        int[] values = {3, 4, 5, 6};

        int capacity = 5;
        
        int maxValue = knap_sack (weights, values, capacity);
        System.out.println("Maximum value : " + maxValue);
        
    }
}