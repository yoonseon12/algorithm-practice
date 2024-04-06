package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {
    static String str;
    static Stack<Character> stack;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        stack = new Stack<>();
        for (int i=0; i<str.length(); i++) {
            char target = str.charAt(i);
            if (target == '(') {
                stack.push(target);
            } else {
                stack.pop();
                if (str.charAt(i-1) == '(') {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
        }
        answer += stack.size();

        System.out.println(answer);
    }
}
