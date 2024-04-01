package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축 {
    static StringBuilder sb;
    static int count, lt, rt;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        sb = new StringBuilder();
        arr = str.toCharArray();

        lt = 0;
        rt = 0;
        count = 0;
        while (rt < arr.length) {
            if (arr[lt] == arr[rt]) {
                count++;
                rt++;
            } else {
                append();
                lt = rt;
                count = 0;
            }
        }
        append();

        System.out.println(sb.toString());
    }

    private static void append() {
        if (count == 1) {
            sb.append(String.valueOf(arr[lt]));
        } else {
            sb.append(String.valueOf(arr[lt])+count);
        }
    }
}
