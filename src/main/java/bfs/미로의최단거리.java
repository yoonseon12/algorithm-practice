package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로의최단거리 {

    static int[][] map, counts;
    static int[] move_x = {0, 1, 0, -1};
    static int[] move_y = {1, 0, -1, 0};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            map = new int[7][7];
            counts = new int[7][7];
            for (int i=0; i<7; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<7; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = BFS();

            System.out.println(result);
        }
    }

    private static int BFS() {
        queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current_x = poll[0];
            int current_y = poll[1];
            map[current_x][current_y] = 1;

            if (current_x == 6 && current_y == 6) {
                return counts[current_x][current_y];
            }

            move(current_x, current_y);
        }

        return -1;
    }

    private static void move(int current_x, int current_y) {
        for (int i=0; i<4; i++) {
            int next_x = current_x + move_x[i];
            int next_y = current_y + move_y[i];
            if (isMoveLimit(next_x, next_y) && map[next_x][next_y] != 1) {
                queue.offer(new int[]{next_x, next_y});
                counts[next_x][next_y] = counts[current_x][current_y] + 1;
            }
        }
    }

    private static boolean isMoveLimit(int next_x, int next_y) {
        return next_x >=0 && next_x < 7 && next_y >=0 && next_y < 7 && map[next_x][next_y] == 0;
    }
}
