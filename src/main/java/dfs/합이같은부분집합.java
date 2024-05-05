package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이같은부분집합 {

    static int N, total;
    static boolean endFlag;
    static int[] arr;
    static String result;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            total = Arrays.stream(arr)
                .sum();
            result = "NO";

            DFS(0, 0);

            System.out.println(result);

        }
    }

    private static void DFS(int index, int sum) {
        if (endFlag || sum > total/2) {
            return;
        }

        if (index == N) {
            if (total - sum == sum) {
                result = "YES";
                endFlag = true;
            }
            return;
        }

        DFS(index + 1, sum + arr[index]);
        DFS(index + 1, sum);
    }
}