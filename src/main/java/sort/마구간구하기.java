package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1 ~ arr[N-1] 사이안에 값이 무조건 있다.
 */
public class 마구간구하기 {
    static int N, C, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            Arrays.sort(arr);
            int lt = 1;
            int rt = arr[N-1];

            while(lt <= rt) {
                int mid = (lt + rt) / 2;
                if (getCount(mid) >= C) {
                    result = mid;
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }

            System.out.println(result);
        }
    }

    private static int getCount(int mid) {
        int count = 1;
        int ep = arr[0]; // 무조건 맨 처음에 넣고 시작하니까 고정
        for (int i=1; i<arr.length; i++) {
            if (arr[i] - ep >= mid) {
                ep = arr[i];
                count++;
            }
        }

        return count;
    }
}
