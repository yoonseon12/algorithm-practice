package bfs.송아지찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송아지찾기_240502 {

    static int S, E, moveCount; // S : 현재위치, E: 최종위치, nodeCount : 가야하는 목적지까지 최소 이동 거리
    static int[] arr = {1, -1, 5}; // 한번 움직일 때 이동할 수 있는 거리
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            isVisit = new boolean[10001];

            int result = BFS(S);

            System.out.println(result);
        }
    }

    private static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisit[start] = true;

        while (!queue.isEmpty()) {
            moveCount++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int current = queue.poll();
                for (int j=0; j<arr.length; j++) {
                    int move = current + arr[j];
                    if (move == E) {
                        return moveCount;
                    }
                    if (!isVisit[move] && isDistLimit(move)) {
                        isVisit[move] = true;
                        queue.offer(move);
                    }
                }
            }
        }
        return 1;
    }

    private static boolean isDistLimit(int move) {
        return move > 0 && move < 10001;
    }

}
