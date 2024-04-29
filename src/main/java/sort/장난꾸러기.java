package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 장난꾸러기 {

    static int N;
    static int[] arr, copyArr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            copyArr = Arrays.copyOf(arr, arr.length);

            Arrays.sort(arr);
            sb = new StringBuilder();
            for(int i=0; i<N; i++) {
                if (arr[i] != copyArr[i]) {
                    sb.append(i+1+" ");
                }
            }

            System.out.println(sb.toString().trim());
        }
    }
}
