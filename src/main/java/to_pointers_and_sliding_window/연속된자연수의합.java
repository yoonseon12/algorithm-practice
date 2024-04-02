package to_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class 연속된자연수의합 {
    static int N, count, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = IntStream.rangeClosed(1,N)
            .toArray();

        int lt=0, rt=0;
        while (rt < N) {
            if (sum == N) {
                count++;
            }
            sum += arr[rt];
            while (sum > N) {
                sum -= arr[lt];
                lt++;
            }
            rt++;
        }

        System.out.println(count);
    }
}
