package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바둑이승차 {
    static int C, N, result;
    static int[] W;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C  = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            W = new int[N];
            for (int i=0; i<N; i++) {
                W[i] = Integer.parseInt(br.readLine());
            }

            DFS(0, 0);

            System.out.println(result);
        }
    }

    private static void DFS(int index, int sum) {
        if (sum > C) {
            return;
        }
        if (index == N) {
            result = Math.max(result , sum);
            return;
        }

        DFS(index + 1, sum + W[index]);
        DFS(index + 1, sum);
    }
}
