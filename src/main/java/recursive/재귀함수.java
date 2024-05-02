package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀함수 {

    static int N;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            recursive(N);
        }
    }

    private static void recursive(int num) {
        if (num == 0) return;
        else {
            recursive(num - 1);
            System.out.println(num);
        }
    }
}
