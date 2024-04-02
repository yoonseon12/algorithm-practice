package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멘토링 {
    static int N, M, answer;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        for (int i=0; i<M; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        for (int i=1; i<=N; i++) { // 학생 I
            for (int j=1; j<=N; j++) { // 학생 J
                // 학생 I와 학생 J의 전체 문제 점수 비교
                int mentorCount = 0;
                for (int k=0; k<M; k++) {
                    int positionI = 0, positionJ = 0;
                    for (int s=0; s<N; s++) {
                        if (arr[k][s] == i) positionI = s;
                        if (arr[k][s] == j) positionJ = s;
                    }
                    if (positionI > positionJ) {
                        mentorCount++;
                    }
                }
                // 문제 개수와 학생 I가 학생 J보다 등수가 앞에있는 횟수가 동일하다면 멘토가 될 수 있다.
                if (mentorCount == M) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
