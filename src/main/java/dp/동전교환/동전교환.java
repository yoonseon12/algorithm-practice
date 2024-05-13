package dp.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전교환 {

    static int N, M;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            coins = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            dp = new int[M+1];

            Arrays.fill(dp, Integer.MAX_VALUE);

            int result = DP();

            System.out.println(result);
        }
    }

    private static int DP() {
        dp[0] = 0;
        for (int i=0; i<N; i++) {
            for (int j=coins[i]; j<=M; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        return dp[M];
    }
}
