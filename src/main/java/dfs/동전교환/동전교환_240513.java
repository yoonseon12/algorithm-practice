package dfs.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전교환_240513 {

    static int N, M, result = Integer.MAX_VALUE;
    static Integer[] coins;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins = new Integer[N];
            for (int i=0; i<N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());

            Arrays.sort(coins, (a, b) -> b - a);

            DFS(0, 0);

            System.out.println(result);
        }
    }

    private static void DFS(int count, int sum) {
        if (sum > M) {
            return;
        }
        if (sum == M ) {
            result = Math.min(result, count);
            return;
        }
        if (count >= result) {
            return;
        }
        for (int i=0; i<N; i++) {
            DFS(count+1, sum+coins[i]);
        }
    }
}
