package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 뒤집은소수 {
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");

        String answer = Arrays.stream(arr)
            .filter(str -> {
                int num = Integer.parseInt(new StringBuilder(str).reverse().toString());
                boolean isPrime = true;
                if (num < 2) {
                    return false;
                }
                for (int i=2; i<num; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                    }
                }
                return isPrime;
            })
            .map(str -> Integer.parseInt(new StringBuilder(str).reverse().toString())+"")
            .collect(Collectors.joining(" "));

        System.out.println(answer);
    }
}
