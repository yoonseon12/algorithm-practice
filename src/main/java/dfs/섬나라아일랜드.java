package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬나라아일랜드 {

    static int N;
    static int[] move_x = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] move_y = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] map;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isVisit = new boolean[N][N];

            int result = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][j] == 1 && !isVisit[i][j]) {
                        result++;
                        DFS(i, j);
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void DFS(int x, int y) {
        isVisit[x][y] = true;

        for (int i=0; i<8; i++) {
            int next_x = x + move_x[i];
            int next_y = y + move_y[i];
            if (isMoveLimit(next_x, next_y) && !isVisit[next_x][next_y]) {
                DFS(next_x, next_y);
            }
        }
    }

    private static boolean isMoveLimit(int next_x, int next_y) {
        return next_x >= 0 && next_x < N && next_y >= 0 && next_y < N && map[next_x][next_y] == 1;
    }
}
