package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼 {
    static int N;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            System.out.println(factorial(N));;
        }
    }

    private static int factorial(int num) {
        if (num == 0) return 1;
        else {
            return num * factorial(num-1);
        }
    }
}
