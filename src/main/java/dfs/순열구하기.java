package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열구하기 {

    static int N, M;
    static int[] arr, pm;
    static boolean[] isVisit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            pm = new int[M];
            isVisit = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            DFS(0);

            System.out.println(sb.toString().trim());
        }
    }

    private static void DFS(int L) {
        if (L == M) {
            for (int x : pm) {
                sb.append(x+ " ");
            }
            sb.delete(sb.length()-1, sb.length());
            sb.append("\n");
            return;
        }
        for (int i=0; i<N; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                pm[L] = arr[i];
                DFS(L+1);
                isVisit[i] = false;
            }
        }
    }
}
