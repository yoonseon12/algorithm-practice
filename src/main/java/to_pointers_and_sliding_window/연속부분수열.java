package to_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속부분수열 {
    static int N, M, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int lt = 0, rt = 0;
        int sum = 0;
        while (rt < N) {
            sum += arr[rt];
            if (sum == M) {
                count++;
            }
            while (sum > M) {
                sum -= arr[lt];
                if (sum == M) {
                    count++;
                }
                lt++;
            }
            rt++;
        }

        System.out.println(count);
    }
}
