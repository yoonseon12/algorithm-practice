package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LRU {

    static int S, N;
    static int[] arr;
    static Queue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            queue = new LinkedList<>();

            for (int i : arr) {
                if (queue.contains(i)) {
                    queue.remove(i);
                } else if (queue.size() >= S) {
                    queue.poll();
                }
                queue.offer(i);
            }

            sb = new StringBuilder();
            while (!queue.isEmpty()) {
                sb.insert(0, queue.poll() + " ");
            }

            // stack = new Stack<>();
            // while (!queue.isEmpty()) {
            //     stack.push(queue.poll());
            // }
            //
            // sb = new StringBuilder();
            // while (!stack.isEmpty()) {
            //     sb.append(stack.pop()+" ");
            // }

            System.out.println(sb.toString().trim());
        }
    }
}
