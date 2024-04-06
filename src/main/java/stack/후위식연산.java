package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위식연산 {
    static String str;
    static Stack<Integer> stack;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                int target = Integer.parseInt(String.valueOf(c));
                stack.push(target);
            } else {
                int j = stack.pop();
                int i = stack.pop();
                if (c == '+') answer = i+j;
                if (c == '-') answer = i-j;
                if (c == '*') answer = i*j;
                if (c == '/') answer = i/j;
                stack.push(answer);
            }
        }

        System.out.println(answer);
    }
}
