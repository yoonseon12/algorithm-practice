package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로탐색_dfs {

    static int N, M, count;
    static boolean[][] map;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N =  Integer.parseInt(st.nextToken());
            M =  Integer.parseInt(st.nextToken());
            map = new boolean[N+1][N+1];
            isVisit = new boolean[N+1];

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                map[start][end] = true;
            }

            isVisit[1] = true;
            DFS(1);

            System.out.println(count);
        }
    }

    private static void DFS(int vertex) {
        if (vertex == N) {
            count++;
            return;
        }
        for (int i=1; i<=N; i++) {
            if (map[vertex][i] && !isVisit[i]) {
                isVisit[i] = true;
                DFS(i);
                isVisit[i] = false;
            }
        }
    }
}

/*
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
*/
