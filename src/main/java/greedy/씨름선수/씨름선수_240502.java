package greedy.씨름선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 씨름선수_240502 {

    static int N, result;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][2];

            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (a, b) -> b[0] - a[0]);

            int maxWeight = Integer.MIN_VALUE;
            for (int i=0; i<N; i++) {
                if (arr[i][1] > maxWeight) {
                    maxWeight = arr[i][1];
                    result++;
                }
            }

            System.out.println(result);
        }

    }
}
