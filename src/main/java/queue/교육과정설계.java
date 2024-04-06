package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정설계 {
    static String need, plan, answer;
    static Queue<Character> needQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        need = br.readLine();
        plan = br.readLine();

        needQueue = new LinkedList<>();
        for (char c : need.toCharArray()) {
            needQueue.offer(c);
        }

        answer = "YES";
        for (char c : plan.toCharArray()) {
            if (needQueue.contains(c) &&  needQueue.peek() == c) {
                needQueue.poll();
            }
        }
        if (!needQueue.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
    }
}