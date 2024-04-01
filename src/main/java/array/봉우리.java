package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 봉우리 {
    static int N, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            int[] s = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            for (int j=0; j<N; j++) {
                arr[i][j] = s[j];
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                boolean isMax = true;
                for (int k=0; k<4; k++) {
                    int x = dx[k];
                    int y = dy[k];
                    if (i+x >= 0 && j+y >= 0 && i+x < N && j+y < N) {
                        int current = arr[i][j];
                        int target = arr[i+x][j+y];
                        if (current <= target) {
                            isMax =  false;
                            break;
                        }
                    }
                }
                if (isMax) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
