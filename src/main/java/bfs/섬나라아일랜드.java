package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isVisit = new boolean[N][N];

            int result = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][j] == 1 && !isVisit[i][j]) {
                        result++;
                        BFS(i, j);
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisit[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current_x = poll[0];
            int current_y = poll[1];
            isVisit[current_x][current_y] = true;

            for (int i=0; i<8; i++) {
                int next_x = current_x + move_x[i];
                int next_y = current_y + move_y[i];
                if (isMoveLimit(next_x, next_y) && !isVisit[next_x][next_y]) {
                    queue.offer(new int[]{next_x, next_y});
                }
            }
        }
    }

    private static boolean isMoveLimit(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N && map[x][y] == 1;
    }
}
