import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Stack;

public class StackAndQueueTest {
    @Test
    @DisplayName("올바른괄호")
    void 올바른괄호() {
        System.out.println(올바른괄호_solution1("(()(()))(()"));
    }
    private String 올바른괄호_solution1(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x=='(') stack.push(x);
            if (x==')') {
                if (stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }

    @Test
    @DisplayName("괄호문자제거")
    void 괄호문자제거() {
        System.out.println(괄호문자제거_solution2("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
    }
    private String 괄호문자제거_solution1(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x=='(') stack.push(x);
            else if (x==')') stack.pop();
            else if (stack.isEmpty()) answer += x;
        }
        return answer;
    }
    private String 괄호문자제거_solution2(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x==')') {
                while (stack.pop() != '(');
            } else stack.push(x);
        }
        for (int i=0; i <stack.size(); i++) {
            answer +=stack.get(i);
        }
        return answer;
    }

    @Test
    @DisplayName("크레인인형뽑기")
    void 크레인인형뽑기() {
        int[][] board =
        {{0, 0, 0, 0, 0}
        ,{0, 0, 1, 0, 3}
        ,{0, 2, 5, 0, 1}
        ,{4, 2, 4, 4, 2}
        ,{3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(크레인인형뽑기_solution(board, moves));
    }
    private int 크레인인형뽑기_solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int pos : moves) {
            for (int i=0; i<board.length; i++) {
                if (board[i][pos-1] != 0){
                    if (!stack.isEmpty() && stack.peek() == board[i][pos-1]) {
                        answer += 2;
                        stack.pop();
                    }
                    else stack.push(board[i][pos-1]);
                    board[i][pos-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    @Test
    @DisplayName("후위식연산")
    void 후위식연산() {
        System.out.println(후위식연산_solution("352+*9-"));
    }
    private int 후위식연산_solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            int lt=0, rt=0;
            if (x >= '0' && x <= '9') {
                stack.push(Character.getNumericValue(x));
            } else {
                if (!stack.isEmpty()) {
                    int result = 0;
                    rt = stack.pop();
                    lt = stack.pop();
                    if (x=='-') result = lt-rt;
                    if (x=='+') result = lt+rt;
                    if (x=='*') result = lt*rt;
                    if (x=='/') result = lt/rt;
                    stack.push(result);
                }
            }
        }
        answer = stack.peek();
        return answer;
    }
    private int 후위식연산_solution2(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x-48); // stack.push(Character.getNumericValue(x)); 과 동일
            } else {
                if (!stack.isEmpty()) {
                    int rt = stack.pop();
                    int lt = stack.pop();
                    int result = 0;
                    if (x=='-') result = lt-rt;
                    if (x=='+') result = lt+rt;
                    if (x=='*') result = lt*rt;
                    if (x=='/') result = lt/rt;
                    stack.push(result);
                }
            }
        }
        answer = stack.peek();
        return answer;
    }

    @Test
    @DisplayName("예시입력 ,찍기")
    void 예시입력() {
        String s = "1 5 3 5 1 2 1 4";
        System.out.println(s.replaceAll(" ",", "));
    }
}
