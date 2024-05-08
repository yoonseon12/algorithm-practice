package dp;

import java.io.*;
import java.util.*;

public class 가장높은탑쌓기 {

    static int N, result;
    static List<Brick> bricks;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N];
            bricks = new ArrayList<>();
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int width = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                bricks.add(new Brick(width, height, weight));
            }
            Collections.sort(bricks);

            DP();

            System.out.println(result);
        }
    }

    private static void DP() {
        dp[0] = bricks.get(0).height;
        result = bricks.get(0).height;

        for (int i=1; i<N; i++) {
            int builtWeight = bricks.get(i).weight;
            int maxHeight = 0;
            for (int j=i-1; j>=0; j--) {
                int weight = bricks.get(j).weight;
                if (builtWeight < weight) {
                    if (dp[j] > maxHeight) {
                        maxHeight = dp[j];
                    }
                }
            }
            dp[i] = maxHeight + builtWeight;
            result = Math.max(result, dp[i]);
        }
    }

    static class Brick implements Comparable<Brick> {
        public int width;
        public int height;
        public int weight;

        public Brick(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.width - this.width;
        }
    }
}

/*
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

25 3 4
16 2 5
9 2 3
4 4 6
1 5 2
*/
