package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에라토스테네스체 {
    /**
     * 루프를 돌면서 자신의 배수를 다 지운다.
     */
    static int N, answer;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];

        for (int i=2; i<=N; i++) {
            if (!visit[i]) {
                answer++;
                for (int j=i; j<=N; j=j+i) {
                    visit[j] = true;
                }
            }
        }

        System.out.println(answer);
    }
}
