package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유효한팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
        String reverseStr = new StringBuilder(str).reverse().toString();
        String answer = str.equals(reverseStr) ? "YES" : "NO";
        System.out.println(answer);
    }
}
