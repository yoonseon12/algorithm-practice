package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자찾기 {
    static String str;
    static char c;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toLowerCase();
        c = br.readLine().toLowerCase().charAt(0);

        for (char ch : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }

        System.out.println(count);
    }
}
