package dp.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전교환_240513 {

    static int N, M;
    static int[] coins, dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            dp = new int[51];
            Arrays.fill(dp, Integer.MAX_VALUE);

            DP();

            System.out.println(dp[M]);
        }
    }

    private static void DP() {
        dp[0] = 0;
        for (int i=0; i<N; i++) {
            for (int j=coins[i]; j<=M; j++) {
                int i1 = dp[j - coins[i]] + 1;
                if (i1 < dp[j]) {
                    dp[j] = i1;
                }
            }
        }
    }

}
