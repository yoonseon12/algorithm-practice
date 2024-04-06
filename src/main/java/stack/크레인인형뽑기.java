package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 크레인인형뽑기 {
    static int N, M, answer;
    static int[][] board;
    static int[] moves;
    static Stack<Integer> basket;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i=0; i<N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        M = Integer.parseInt(br.readLine());
        moves = new int[M];
        moves = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        basket = new Stack<>();
        for (int crane : moves) {
            for (int i=0; i<N; i++) {
                int doll = board[i][crane-1];
                if (doll != 0) {
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer+=2;
                    } else {
                        basket.push(doll);
                    }
                    board[i][crane-1] = 0;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
