package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 격자판최대합 {
    static int N;
    static int maxRowSum, maxColSum, leftCrossSum, rightCrossSum;
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
        maxRowSum = 0;
        maxColSum = 0;
        leftCrossSum = 0;
        rightCrossSum = 0;
        for (int i=0; i<N; i++) {
            int rowSum = 0, colSum = 0;
            for (int j=0; j<N; j++) {
                if (i == j) {
                    leftCrossSum += arr[i][j];
                }
                if (i+j == N-1) {
                    rightCrossSum += arr[i][j];
                }
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            maxRowSum = Math.max(rowSum, maxRowSum);
            maxColSum = Math.max(colSum, maxColSum);
        }
        int maxValue = Math.max(Math.max(maxRowSum, maxColSum), Math.max(leftCrossSum, rightCrossSum));

        System.out.println(maxValue);
    }
}
