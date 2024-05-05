package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수구하기 {

    static int N, M, max_score;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][2];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            DFS(0 , 0 ,0);

            System.out.println(max_score);
        }
    }

    private static void DFS(int index, int sum_time, int sum_score) {
        if (sum_time > M) {
            return;
        }
        if (index == N) {
            max_score = Math.max(max_score, sum_score);
            return;
        }

        int score = arr[index][0];
        int time = arr[index][1];

        DFS(index+1, sum_time + time, sum_score + score);
        DFS(index+1, sum_time, sum_score);
    }
}
