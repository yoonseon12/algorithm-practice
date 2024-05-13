package dfs.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 문제에서 동전 최대 개수가 12개라서 DFS로 가능하다.
 * 만약 동전 개수가 더 커진다면 DP 냅색 알고리즘으로 풀어야한다.
 */
public class 동전교환 {

    static int N, M, result = 13;
    static Integer[] coins;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            coins = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());

            Arrays.sort(coins, Collections.reverseOrder());

            DFS(0, 0);

            System.out.println(result);
        }
    }

    private static void DFS(int count, int sum) {
        if (count >= result ) {
            return;
        }
        if (sum > M) {
            return;
        }
        if (sum == M) {
            result = Math.min(result, count);
            return;
        }
        for (int i=0; i<N; i++) {
            DFS(count+1, sum+coins[i]);
        }
    }

}
