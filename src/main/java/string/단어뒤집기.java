package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기 {
    static int N;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new StringBuilder();
        for (int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            answer.append(sb.reverse());
            answer.append("\n");
        }

        System.out.println(answer.toString());
    }
}
