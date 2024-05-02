package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진수출력 {

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
            recursive(num / 2);
            System.out.print(num % 2);
        }
    }

    //     0
    // 2 | 1  -> 1
    // 2 | 2  -> 0
    // 2 | 5  -> 1
    // 2 | 10 -> 0

}
