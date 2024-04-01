package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 점수계산 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int score = 0;
        int sum = 0;
        for (int i : arr) {
            if (i == 1) {
                score++;
            } else {
                score = 0;
            }
            sum += score;
        }

        System.out.println(sum);
    }
}
