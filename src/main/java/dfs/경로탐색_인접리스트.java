package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 정점이 너무 많아지면 인접행렬로는 풀면 비효율적 이기에 인접 리스트로 풀어야 한다.
 */
public class 경로탐색_인접리스트 {

    static int N, M, count;
    static List<ArrayList<Integer>> list;
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

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list.get(start).add(end);
            }

            isVisit[1] = true;
            DFS(1);

            System.out.println(count);

        }
    }

    public static void DFS(int vertex) {
        if (vertex == N) {
            count++;
            return;
        }
        for (int i : list.get(vertex)) {
            if (isVisit[i] == false) {
                isVisit[i] = true;
                DFS(i);
                isVisit[i] = false;
            }
        }
    }
}
