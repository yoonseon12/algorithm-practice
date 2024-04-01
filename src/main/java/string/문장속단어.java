package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문장속단어 {
    static int size;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = 0;
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.length() > size) {
                answer = str;
                size = str.length();
            }
        }

        System.out.println(answer);
    }
}
