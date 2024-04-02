package to_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 공통원소구하기 {
    static int N, M;
    static int[] nArr, mArr;
    static List<Integer> list;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nArr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        M = Integer.parseInt(br.readLine());
        mArr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        list = new ArrayList<>();
        int pointerA = 0;
        int pointerB = 0;
        while (pointerA < N && pointerB < M) {
            if (nArr[pointerA] == mArr[pointerB]) {
                list.add(nArr[pointerA]);
                pointerA++;
            } else if (nArr[pointerA] < mArr[pointerB]) {
                pointerA++;
            } else {
                pointerB++;
            }
        }

        answer = list.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));

        System.out.println(answer);
    }
}
