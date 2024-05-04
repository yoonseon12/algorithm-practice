package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프최단거리 {

    static int N, M;
    static List<ArrayList<Integer>> list;
    static int[] result;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i=0; i<=N; i++) {
                list.add(new ArrayList<>());
            }
            isVisit = new boolean[N+1];
            result = new int[N+1];

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list.get(start).add(end);
            }

            BFS(1);

            for (int i=2; i<=N; i++) {
                System.out.println(i + " : " + result[i]);
            }
        }
    }

    private static void BFS(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        isVisit[vertex] = true;
        queue.offer(vertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : list.get(current)) {
                if (!isVisit[i]) {
                    isVisit[i] = true;
                    result[i] = result[current] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}

/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
 */
