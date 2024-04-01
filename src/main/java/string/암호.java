package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호 {
    static int N, size;
    static String str;
    static String[] strArr;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        str = br.readLine().replace("#","1").replace("*","0");
        size = str.length() / N;
        strArr = new String[N];

        for (int i = 0; i < N; i++) {
            char c = (char)Integer.parseInt(str.substring(i*size, (i+1)*size), 2);
            answer.append(c);
        }

        System.out.println(answer.toString());
    }
}
