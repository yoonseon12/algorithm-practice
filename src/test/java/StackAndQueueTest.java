import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
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
    @DisplayName("쇠막대기")
    void 쇠막대기() {
        System.out.println(쇠막대기_solution("()(((()())(())()))(())"));
    }
    private int 쇠막대기_solution(String str) {
        int answer = 0; // 쇠막대기와 레이저의 총합을 저장할 변수
        Stack<Character> stack = new Stack<>(); // 여는 괄호 '('를 저장할 스택
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i)); // 여는 괄호 '('를 스택에 추가
            }
            if (str.charAt(i) == ')') {
                stack.pop(); // 닫는 괄호 ')'를 만나면 스택에서 여는 괄호 '('를 제거
                // 바로 직전 문자가 여는 괄호 '('인 경우는 레이저로 판단
                if (str.charAt(i-1) == '(') {
                    answer += stack.size(); // 현재 스택의 크기가 레이저로 자르는 막대기의 수
                } else {
                    answer += 1; // 아니면 닫는 괄호 ')'는 하나의 쇠막대기의 끝을 나타냄
                }
            }
        }
        return answer; // 쇠막대기와 레이저의 총합 반환
    }

    @Test
    @DisplayName("공주구하기")
    void 공주구하기() {
        System.out.println(공주구하기_solution(8, 3));
    }
    private int 공주구하기_solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) queue.offer(i); // 1부터 n까지 번호를 큐에 추가
        while (!queue.isEmpty()) {
            for (int i=1; i<k; i++) queue.offer(queue.poll()); // k-1번째까지의 번호를 큐의 맨 뒤로 이동시킴
            queue.poll();  // k번째 번호를 큐에서 제거
            if (queue.size() == 1) answer = queue.poll(); // 큐에 남아 있는 마지막 번호를 정답으로 설정
        }
        return answer;
    }

    @Test
    @DisplayName("교육과정설계")
    void 교육과정설계() {
        System.out.println(교육과정설계_solution2("CBA", "CBDAGE"));
    }
    private String 교육과정설계_solution1(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char x : plan.toCharArray()) queue.offer(x);
        while (need.length() > 0) {
            char c = need.charAt(0);
            for (int i=0; i<plan.length(); i++) {
                if (!queue.contains(c)) return "NO";
                if (c == queue.poll()) break;
            }
            need = need.substring(1, need.length());
        }
        return answer;
    }
    private String 교육과정설계_solution2(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char x : need.toCharArray()) queue.offer(x);
        for (char x : plan.toCharArray()) {
            if (queue.contains(x)) {
                if( x != queue.poll()) return "NO";
            }
        }
        if (!queue.isEmpty()) return "NO";
        return answer;
    }


    @Test
    @DisplayName("예시입력 ,찍기")
    void 예시입력() {
        String s = "1 5 3 5 1 2 1 4";
        System.out.println(s.replaceAll(" ",", "));
    }
}
