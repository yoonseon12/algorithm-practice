package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 뮤직비디오 {

    static int N, M, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            int lt = Arrays.stream(arr).max().getAsInt();
            int rt = Arrays.stream(arr).sum();

            while (lt <= rt) {
                int mid = (lt+rt)/2;
                if (getCapacity(mid) <= M) {
                    result = mid;
                    rt = mid-1;
                } else {
                    lt = mid+1;
                }
            }

            System.out.println(result);
        }
    }

    private static int getCapacity(int mid) {
        int count = 0;
        int sum = 0;
        for (int i=0; i<N; i++) {
            if (sum + arr[i] <= mid) {
                sum += arr[i];
            } else {
                sum = arr[i];
                count++;
            }
        }
        if (sum != 0) {
            count++;
        }

        return count;
    }
}
