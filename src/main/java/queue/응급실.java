package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 응급실 {
    static int N, M, count;
    static Queue<Patient> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        queue = new LinkedList<>();
        for (int i=0; i<N; i++) {
            queue.offer(new Patient(i, arr[i]));
        }

        while (!queue.isEmpty()) {
            Patient target = queue.poll();
            boolean isMax = true;
            for (Patient patient : queue) {
                if (target.emergencyDegree < patient.emergencyDegree) {
                    queue.offer(target);
                    isMax = false;
                    break;
                }
            }
            if (isMax) {
                count++;
                if (target.order == M) {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    static class Patient {
        public int order;
        public int emergencyDegree;

        public Patient(int order, int emergencyDegree) {
            this.order = order;
            this.emergencyDegree = emergencyDegree;
        }
    }
}
