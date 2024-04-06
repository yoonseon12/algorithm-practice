package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 올바른괄호 {
    static String str, answer;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        answer = "YES";
        stack = new Stack<>();
        for (int i=0; i<str.length(); i++) {
            char target = str.charAt(i);
            if (target == ')') {
                if (stack.isEmpty()) {
                    answer = "NO";
                    break;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(target);
            }
        }
        if (!stack.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
    }
}
