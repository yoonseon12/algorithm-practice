package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 몇명과 가장 많이 같은 반이 됐었는지 추출하는 문제..
 1학년때 같은 반 했던 친구가 2학년 때도 같은 반이면 카운트 하면 안된다..
 현재 코드는 문제를 잘 못 이해해야해서 카운트 하고있음.
 */
public class 임시반장정하기 {
    static final int grade = 5;
    static int N;
    static int[][] arr;
    static boolean[][] isCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][grade];
        isCheck = new boolean[N][grade];

        for (int i=0; i<N; i++) {
            int[] classes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            for (int j=0; j<grade; j++) {
                arr[i][j] = classes[j];
            }
        }

        for (int i=0; i<grade; i++) {
            for (int j=0; j<N; j++) {
                int target = arr[j][i];
                for (int k=0; k<N; k++) {
                    if (k != j && arr[k][i] == target) {
                        isCheck[j][i] = true;
                    }
                }
            }
        }

        int student = 0;
        int max = 0;
        for (int i=0; i<N; i++) {
            int score = 0;
            for (int j=0; j<grade; j++) {
                if (isCheck[i][j]) {
                    score++;
                }
            }
            if (max < score) {
                student = i;
                max = score;
            }
        }

        System.out.println(student+1);
    }
}