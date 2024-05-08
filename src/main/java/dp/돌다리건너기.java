package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌다리건너기 {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N+2]; // 완전히 건너는 것 까지여서 배열 마지막 +1 해주어야함.

            int result = DP();

            System.out.println(result);
        }
    }

    private static int DP() {
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<N+2; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N+1];
    }
}
