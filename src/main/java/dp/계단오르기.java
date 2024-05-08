package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N+1];

            int result = DP();

            System.out.println(result);
        }
    }

    private static int DP() {
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=N; i++) {
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[N];
    }
}
