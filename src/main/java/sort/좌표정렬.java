package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표정렬 {
    static int N;
    static int[][] points;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            points = new int[N][2];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(points, (p1, p2) -> {
                if (p1[0] == p2[0]) {
                    return p1[1] - p2[1];
                }
                return p1[0] - p2[0];
            });

            for (int[] p : points) {
                System.out.println(p[0]+" "+p[1]);
            }
        }
    }
}
