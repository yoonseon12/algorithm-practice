package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 큰수출력하기 {
    static int N;
    static String[] strArr;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strArr = br.readLine().split(" ");
        answer = new StringBuilder();
        append(strArr[0]);
        for (int i=1; i<N; i++) {
            if (Integer.parseInt(strArr[i]) > Integer.parseInt(strArr[i-1])) {
                append(strArr[i]);
            }
        }

        System.out.println(answer.toString());
    }

    private static void append(String str) {
        answer.append(str+" ");
    }
}
