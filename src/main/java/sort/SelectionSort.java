package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectionSort {
    static int N;
    static int[] arr;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        for (int i=0; i<N-1; i++) {
            int minValueIndex = i;
            for (int j=i+1; j<N; j++) {
                if (arr[j] < arr[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            if (minValueIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minValueIndex];
                arr[minValueIndex] = temp;
            }
        }

        answer = Arrays.stream(arr)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));

        System.out.println(answer);
    }
}
