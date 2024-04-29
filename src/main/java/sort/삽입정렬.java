package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 삽입정렬 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            for (int i=1; i<N; i++) {
                int temp = arr[i], j;
                for (j=i-1; j>=0; j--) {
                    if (temp < arr[j]) {
                        arr[j+1] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j+1] = temp;
            }

            String result = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

            System.out.println(result);
        }
    }
}
