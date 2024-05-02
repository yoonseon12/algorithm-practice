package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수열_메모이제이션 {

    static int N;
    static int[] fibo;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            fibo = new int[N];

            sb = new StringBuilder();
            for (int i=1; i<=N; i++) {
                sb.append(recursive(i)+" ");
            }

            System.out.println(sb.toString().trim());
        }

    }

    public static int recursive(int n) {
        if (n==1 || n==2) return 1;
        else {
            if (fibo[n-1] != 0) {
                return fibo[n-1];
            }
            return fibo[n-1] = recursive(n - 1) + recursive(n - 2);
        }
    }
}
