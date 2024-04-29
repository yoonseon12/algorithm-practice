package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 중복확인 {

    static int N;
    static int[] arr;
    static String result;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            set = new HashSet<>();
            result = "U";
            for (int i : arr) {
                if (!set.add(i)) {
                    result = "D";
                }
            }

            System.out.println(result);
        }
    }
}
