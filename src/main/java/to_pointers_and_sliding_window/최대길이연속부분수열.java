package to_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 순회하면서 1 항상 max 값을 증가시킨다.
 * 만약 0을 만나면 1로 바꾸었다고 가정하고 변경한 횟수를 changeCount에 누적한다.
 * 0을 1로 바꾼 횟수가 초과할 경우
 * lt가 0을 1로 변경한 부분을 만날 때 까지 순회하며 lt++ 하여 한칸씩 이동시킨다.
 * 0인거까지 lt가 오면 1로 변경한 걸 회수(changeCount--) 했다고 하고 다음 칸으로 이동한다.
 * 다시 0을 1로 바꿀 수 있으므로 다시 처음 처럼 순회한다.
 * 누적된 max값을 반환한다.
 * -> rt-lt+1 값은 현재 1만 있는 값
 */
public class 최대길이연속부분수열 {
    static int N, K, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int lt = 0;
        int changeCount = 0;
        for (int rt=0; rt<N; rt++) {
            if (arr[rt] == 0) {
                changeCount++;
            }
            while (changeCount > K) {
                if (arr[lt] == 0) {
                    changeCount--;
                }
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }

        System.out.println(answer);
    }
}
