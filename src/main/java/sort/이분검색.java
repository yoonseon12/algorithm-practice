package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분검색 {
    static int N, M, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            Arrays.sort(arr);

            int lt = 0, rt = N;

            while(true) {
                int mid = (rt+lt)/2;
                if (arr[mid] == M) {
                    result = mid+1;
                    break;
                } else if (M > arr[mid]) {
                    lt = mid;
                } else {
                    rt = mid;
                }
            }

            System.out.println(result);
        }
    }
}
