package to_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최대매출 {
    static int N, K;
    static int max, sum;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        for (int i=0; i<K; i++) {
            sum += arr[i];
        }
        max = sum;
        int lt = 0;
        int rt = K-1;
        while (rt < N-1) {
            sum = sum - arr[lt];
            lt++;
            rt++;
            sum = sum + arr[rt];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
