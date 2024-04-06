package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호문자제거 {
    static String str, answer;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        answer = "";
        stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    answer += c;
                }
            }
        }

        System.out.println(answer);
    }
}
