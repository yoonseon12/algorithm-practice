package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 피보나치수열 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        for (int i=2; i<N; i++) {
            arr[i] = arr[i-2]+arr[i-1];
        }

        String answer = Arrays.stream(arr)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));

        System.out.println(answer);
    }
}
