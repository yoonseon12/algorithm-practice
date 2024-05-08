package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대부분증가수열 {

    static int N, result;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[N];

            DP();

            System.out.println(result);
        }
    }

    private static void DP() {
        dp[0] = 1;
        for (int i=1; i<N; i++) {
            int value = 0;
            for (int j=0; j<i; j++) {
                if (arr[i] >= arr[j]) {
                    value = Math.max(dp[j], value);
                }
            }
            dp[i] = value + 1;
            result = Math.max(dp[i], result);
        }
    }
}

/*
9
2 7 5 8 6 4 7 12 3
*/

