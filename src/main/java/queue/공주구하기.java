package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주구하기 {
    static int N, K;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            queue.offer(i);
        }

        int count = 0;
        while (queue.size() > 1) {
            count++;
            if (count == K) {
                queue.poll();
                count = 0;
            } else {
                queue.offer(queue.poll());
            }
        }

        System.out.println(queue.poll());
    }
}
