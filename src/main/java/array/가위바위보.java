package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가위바위보 {
    static int N;
    static int[] A, B;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        B = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        for (int i=0; i<N; i++) {
            battle(i);
        }
        answer.deleteCharAt(answer.length()-1);

        System.out.println(answer);
    }

    private static void battle(int i) {
        if (A[i] == B[i]) {
            answer.append("D");
        } else if (A[i] - B[i] == 1 || A[i] - B[i] == -2) {
            answer.append("A");
        } else {
            answer.append("B");
        }
        answer.append("\n");
    }
}
