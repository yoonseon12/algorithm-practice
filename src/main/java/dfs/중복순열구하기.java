package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다음에 다시 풀어보자
 */
public class 중복순열구하기 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[M];

            DFS(0);
        }
    }

    private static void DFS(int index) {
        if (index == M) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        for (int i=1; i<=N; i++) {
            arr[index] = i;
            DFS(index + 1);
        }
    }
}
