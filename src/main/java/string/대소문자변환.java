package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대소문자변환 {
    static StringBuilder sb;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        System.out.println(sb.toString());
    }
}
